package com.ilya.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * JumpFurther: TopCoder
 *
 * Little Fox Jiro is standing at the bottom of a long flight of stairs.
 * The bottom of the stairs has number 0, the bottommost step has number 1,
 * the next step has number 2, and so on. The staircase is so long that Jiro
 * is guaranteed not to reach its top.
 *
 * Jiro will now perform N consecutive actions. The actions are numbered 1 through N, in order.
 * When performing action X, Jiro chooses between two options: either he does nothing, or he jumps
 * exactly X steps up the stairs. In other words, if Jiro starts performing action X standing on step Y,
 * he will end it either on step Y, or on step Y+X.
 *
 * For example, if N=3, Jiro will make three consecutive choices: whether or not to jump 1 step upwards,
 * 2 steps upwards, and then 3 steps upwards.
 *
 * One of the steps is broken. The number of this step is badStep. Jiro cannot jump onto this step.
 *
 * You are given the ints N and badStep. Compute and return the number of the topmost step that can be
 * reached by Jiro.
 *
 * @author iizrailevsky
 *
 */
public class JumpFurther {

    public JumpFurther() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the farthest step that can be reached
     * by Jiro if found, -1 otherwise
     *
     * @param N Number of actions
     * @param badStep Number of the bad step
     * @return farthest step that can be reached
     * by Jiro if found, -1 otherwise
     */
    public int farthest(int N, int badStep) {
        // error checking
        if (N <= 0 || badStep <= 0) {
            return -1;
        }

        // init variables
        int[] initActions = new int[N + 1];
        List<int[]> routes = new ArrayList<>();

        // generate various routes
        generateRoutes(initActions, 1, N, badStep, routes);

        // find farthest route
        int maxStep = -1;
        int[] farthestRoute = null;
        for (int[] route : routes) {
            if (route[N] > maxStep) {
                maxStep = route[N];
                farthestRoute = route;
            }
        }

        // print farthest route
        if (farthestRoute != null) {
            System.out.println(Arrays.toString(farthestRoute));
        }

        return maxStep;
    }

    /**
     * Generates possible step routes given number of actions and steps so far
     * and populates them in the routes list
     * @param actions
     * @param index
     * @param N
     * @param badStep
     * @param routes
     */
    private void generateRoutes(int[] actions, int index, int N, int badStep, List<int[]> routes) {
        // base case
        if (index > N) {
            routes.add(actions);
            return;
        }

        // init variables
        int stepsSoFar = actions[index - 1];

        // try standing
        int[] actionStand = Arrays.copyOf(actions, actions.length);
        actionStand[index] = stepsSoFar;
        generateRoutes(actionStand, index + 1, N, badStep, routes);

        // try jumping if not stepping on bad step
        if ((stepsSoFar + index) != badStep) {
            int[] actionJump = Arrays.copyOf(actions, actions.length);
            actionJump[index] = stepsSoFar + index;
            generateRoutes(actionJump, index + 1, N, badStep, routes);
        }
    }

    /**
     * Returns the farthest step that can be reached
     * by Jiro if found, -1 otherwise
     *
     * @param N Number of actions
     * @param badStep Number of the bad step
     * @return farthest step that can be reached
     * by Jiro if found, -1 otherwise
     */
    public int farthestIterative(int N, int badStep) {
        // error checking
        if (N <= 0 || badStep <= 0) {
            return -1;
        }

        int stepsOpt1 = 0;
        int stepsOpt2 = 1;
        if (badStep == 1) {
            stepsOpt2 = 0;
        }

        for (int i = 2; i <= N; i++) {
            // not stepping on badStep?
            if (stepsOpt1 + i != badStep) {
                stepsOpt1 += i;
            }
            if (stepsOpt2 + i != badStep) {
                stepsOpt2 += i;
            }
        }

        return Math.max(stepsOpt1, stepsOpt2);

    }


    public static void main(String[] args) {
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(3, 3));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(1, 0));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(2, 2));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(2, 1));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(10, 10));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(10, 9));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(1, 757065));
        System.out.println("Farthest step: " + new JumpFurther().farthestIterative(1313, 5858));
    }


}
