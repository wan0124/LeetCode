package wan.leetcode.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Car_Fleet_853 {
	class Car {
		int position;
		double spend;

		public Car(int position, int target, int speed) {
			this.position = position;
			this.spend = (double) (target - position) / (double) speed;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		List<Car> carList = new ArrayList<Car>();
		for (int i = 0; i < position.length; i++) {
			carList.add(new Car(position[i], target, speed[i]));
		}

		carList.sort(new Comparator<Car>() {

			@Override
			public int compare(Car car1, Car car2) {
				return car1.position - car2.position;
			}

		});

		Stack<Car> stack = new Stack<Car>();

		for (Car car : carList) {
			// check if the car before is quicker than this car
			while (!stack.empty() && stack.peek().spend <= car.spend) {
				// if it does, it will join this car and be a car fleet
				stack.pop();
			}
			stack.push(car);
		}

		return stack.size();
	}
}
