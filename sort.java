import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SortingVisualizerPro extends JFrame {
    private int[] array;
    private int currentI = -1, currentJ = -1;
    private int delay = 50; // default speed
    private String algorithm = "Bubble";
    private SortingPanel sortingPanel;
    private Timer timer;
    private int i = 0, j = 0;
    private int arraySize = 80;

    public SortingVisualizerPro() {
        setTitle("Sorting Visualizer");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        array = new int[arraySize];
        shuffleArray();

        sortingPanel = new SortingPanel();
        add(sortingPanel, BorderLayout.CENTER);

        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JComboBox<String> algoDropdown = new JComboBox<>(new String[]{
                "Bubble", "Selection", "Insertion", "Quick", "Merge"
        });

        JTextField sizeField = new JTextField(String.valueOf(arraySize), 5);

        JButton startBtn = new JButton("Start");
        JButton shuffleBtn = new JButton("Shuffle");

        JSlider speedSlider = new JSlider(10, 200, delay);
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        speedSlider.addChangeListener(e -> delay = speedSlider.getValue());

        startBtn.addActionListener(e -> {
            algorithm = (String) algoDropdown.getSelectedItem();
            arraySize = Integer.parseInt(sizeField.getText());
            array = new int[arraySize];
            shuffleArray();
            startSorting(algorithm);
        });

        shuffleBtn.addActionListener(e -> shuffleArray());

        controlPanel.add(new JLabel("Algorithm:"));
        controlPanel.add(algoDropdown);
        controlPanel.add(new JLabel("Array Size:"));
        controlPanel.add(sizeField);
        controlPanel.add(startBtn);
        controlPanel.add(shuffleBtn);
        controlPanel.add(new JLabel("Speed:"));
        controlPanel.add(speedSlider);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void shuffleArray() {
        Random rand = new Random();
        for (int k = 0; k < array.length; k++) {
            array[k] = rand.nextInt(400) + 50;
        }
        currentI = currentJ = -1;
        i = j = 0;
        if (timer != null) timer.stop();
        sortingPanel.repaint();
    }

    private void startSorting(String algo) {
        i = 0; j = 0;

        if (timer != null && timer.isRunning()) timer.stop();

        switch (algo) {
            case "Bubble" -> bubbleSortTimer();
            case "Selection" -> selectionSortTimer();
            case "Insertion" -> insertionSortTimer();
            case "Quick" -> quickSortTimer();
            case "Merge" -> mergeSortTimer();
        }
    }

    // Timer-based Bubble Sort
    private void bubbleSortTimer() {
        timer = new Timer(delay, e -> {
            if (i < array.length - 1) {
                if (j < array.length - i - 1) {
                    currentJ = j;
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                    j++;
                } else {
                    j = 0;
                    i++;
                }
                sortingPanel.repaint();
            } else {
                currentJ = -1;
                sortingPanel.repaint();
                timer.stop();
            }
        });
        timer.start();
    }

    // Timer-based Selection Sort
    private int minIdx = -1;
    private void selectionSortTimer() {
        i = 0; j = i + 1; minIdx = i;
        timer = new Timer(delay, e -> {
            if (i < array.length - 1) {
                if (j < array.length) {
                    currentJ = j;
                    if (array[j] < array[minIdx]) minIdx = j;
                    j++;
                } else {
                    int temp = array[i];
                    array[i] = array[minIdx];
                    array[minIdx] = temp;
                    i++;
                    j = i + 1;
                    minIdx = i;
                }
                sortingPanel.repaint();
            } else {
                currentJ = -1;
                sortingPanel.repaint();
                timer.stop();
            }
        });
        timer.start();
    }

    // Timer-based Insertion Sort
    private int key, k;
    private boolean insertionInit = false;
    private void insertionSortTimer() {
        i = 1;
        timer = new Timer(delay, e -> {
            if (!insertionInit) {
                key = array[i];
                k = i - 1;
                insertionInit = true;
            }
            if (i < array.length) {
                if (k >= 0 && array[k] > key) {
                    array[k + 1] = array[k];
                    k--;
                } else {
                    array[k + 1] = key;
                    i++;
                    insertionInit = false;
                }
                currentJ = k + 1;
                sortingPanel.repaint();
            } else {
                currentJ = -1;
                sortingPanel.repaint();
                timer.stop();
            }
        });
        timer.start();
    }

    // Quick Sort (simplified stack-based animation)
    private int[] stackLow, stackHigh;
    private int top = -1;
    private boolean quickInit = false;
    private void quickSortTimer() {
        if (!quickInit) {
            stackLow = new int[array.length];
            stackHigh = new int[array.length];
            top = 0;
            stackLow[top] = 0;
            stackHigh[top] = array.length - 1;
            quickInit = true;
        }
        timer = new Timer(delay, e -> {
            if (top < 0) {
                currentJ = -1;
                sortingPanel.repaint();
                timer.stop();
                return;
            }
            int low = stackLow[top];
            int high = stackHigh[top--];
            int pi = partition(low, high);
            if (pi - 1 > low) {
                stackLow[++top] = low;
                stackHigh[top] = pi - 1;
            }
            if (pi + 1 < high) {
                stackLow[++top] = pi + 1;
                stackHigh[top] = high;
            }
            sortingPanel.repaint();
        });
        timer.start();
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            currentJ = j;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Merge Sort (simplified, recursive with delay)
    private boolean mergeInit = false;
    private void mergeSortTimer() {
        new Thread(() -> {
            try {
                mergeSort(array, 0, array.length - 1);
                currentJ = -1;
                sortingPanel.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void mergeSort(int[] arr, int l, int r) throws InterruptedException {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) throws InterruptedException {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
            currentJ = k;
            sortingPanel.repaint();
            Thread.sleep(delay);
        }
        while (i < n1) { arr[k++] = L[i++]; sortingPanel.repaint(); Thread.sleep(delay); }
        while (j < n2) { arr[k++] = R[j++]; sortingPanel.repaint(); Thread.sleep(delay); }
    }

    private class SortingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth() / array.length;
            for (int k = 0; k < array.length; k++) {
                if (k == currentJ || k == currentJ + 1) g.setColor(Color.RED);
                else g.setColor(Color.BLUE);
                g.fillRect(k * width, getHeight() - array[k], width - 2, array[k]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizerPro gui = new SortingVisualizerPro();
            gui.setVisible(true);
        });
    }
}
