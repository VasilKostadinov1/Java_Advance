package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(e -> (e.getName().equals(name) && e.getMuscle().equals(muscle)));
    }

    //returns the exercise with the given name and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle)).findFirst().orElse(null);

    }

    //returns the exercise which is burned the most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getMuscle)).get();

    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", this.type)).append(System.lineSeparator());
        this.exercises.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
