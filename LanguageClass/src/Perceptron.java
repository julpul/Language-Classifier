import java.util.Arrays;
import java.util.List;

public class Perceptron {
    double[] weights;
    double eta;
    double theta = 1;

    public Perceptron( double eta) {
        this.weights = new double[26];
        this.eta = eta;
        generateWeights();
    }
    private void generateWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = 2*Math.random()-1;
        }
    }

    public int compute(List<Double> input_data){
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i]*input_data.get(i);
        }
        return sum>=theta ? 1 : 0;
    }
    public void updateWeights(List<Double> input_data,int decision){
        int compute = compute(input_data);
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i]+(decision-compute)*input_data.get(i)*eta;
        }
        updateTheta(compute,decision);
    }
    public void updateTheta(int compute,int decision){
        this.theta = theta+(decision-compute)*eta;
    }

    public void train(List<List<Double>> data, List<Integer> decisions,int iterations){
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < decisions.size(); j++) {
                updateWeights(data.get(j),decisions.get(j));
            }
            stats(data,decisions);
        }
    }
    private void stats(List<List<Double>> data, List<Integer> decisions){
        int right_compute = 0;
        int other_types = 0;
        int miss_compute = 0;
        for (int i = 0; i < decisions.size(); i++) {
            int current_compute = compute(data.get(i));
            int current_decision = decisions.get(i);
            if (current_compute == current_decision && current_decision == 1){
                right_compute++;
            } else if (current_compute == current_decision && current_decision == 0){
                other_types++;
            }else {
                miss_compute++;
            }
        }

        System.out.println("\nright_compute_setosa: "+right_compute+"\nright_compute_othertypes: "+other_types+"\nmiss_compute: "+miss_compute);
    }


    @Override
    public String toString() {
        return "Perceptron{" +
                "weights=" + Arrays.toString(weights) +
                ", eta=" + eta +
                ", theta=" + theta +
                '}';
    }
}