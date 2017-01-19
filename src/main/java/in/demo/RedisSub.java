package in.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Scanner;

/**
 * Created by vijaysy on 30/03/16.
 */
public class RedisSub {

	public static void main(String args[]) {
		Jedis jedis = new Jedis("localhost");
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter the channel name:");
		String channel = scanner.nextLine();
		System.out.println("Starting subscriber for channel " + channel);

		while (true) {
			jedis.subscribe(new JedisPubSub() {
				@Override
				public void onMessage(String channel, String message) {

					System.out.println("Received message:" + message);
				}

				@Override
				public void onSubscribe(String channel, int subscribedChannels) {
					System.out.println("channel:" + channel + " subscrbed channel:" + subscribedChannels);
				}

				@Override
				public void onUnsubscribe(String channel, int subscribedChannels) {
				}

				@Override
				public void onPMessage(String pattern, String channel, String message) {
				}

				@Override
				public void onPUnsubscribe(String pattern, int subscribedChannels) {
				}

				@Override
				public void onPSubscribe(String pattern, int subscribedChannels) {
				}

			}, channel);
		}
	}
}