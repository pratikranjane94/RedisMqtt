package in.demo;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

/**
 * Created by vijaysy on 30/03/16.
 */
public class RedisPub {
	public static void main(String args[]) {
		Jedis jedis = new Jedis("localhost");
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter the channel name:");
		String channel = scanner.nextLine();
		System.out.println("Starting publisher for channel " + channel);

		while (true) {
			System.out.println("Enter the string to Publish:");
			String msg = scanner.nextLine();
			jedis.publish(channel, msg);

		}
	}
}