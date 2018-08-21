package com.company;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PMToP {
	/**
	 * 产品经理提出idea，程序员去解决
	 */

	private static Scanner sc = new Scanner(System.in);

	static class IdeaTask {
		int pmSeq;
		int raiseTime;
		int prio;
		int timeCost;
		int endTime;

		public IdeaTask(int pmSeq, int raiseTime, int prio, int timeCost) {
			this.pmSeq = pmSeq;
			this.raiseTime = raiseTime;
			this.prio = prio;
			this.timeCost = timeCost;
		}
	}

	static class PM {
		PriorityQueue<IdeaTask> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.raiseTime));

		// 给定程序员开始工作的时间，找到这个PM最想完成的任务
		IdeaTask mostDesiredTask(int startTime) {
			PriorityQueue<IdeaTask> pq2 = new PriorityQueue<>((x, y) -> {
				if (x.prio != y.prio)
					return y.prio - x.prio;
				else {
					if (x.timeCost != y.timeCost)
						return x.timeCost - y.timeCost;
					else
						return x.raiseTime - y.raiseTime;
				}
			});
			while (pq.peek() != null && pq.peek().raiseTime <= startTime) {
				pq2.offer(pq.poll());
			}
			IdeaTask mostDesiredTask = (pq2.isEmpty()) ? pq.poll() : pq2.poll();
			while (!pq2.isEmpty()) {
				pq.offer(pq2.poll());
			}
			return mostDesiredTask;
		}
	}

	static class Programmer {
		int nextWorkTime;// 下次可以工作的时间

		public Programmer(int nextWorkTime) {
			this.nextWorkTime = nextWorkTime;
		}
	}

	// 从多个PM 最想要完成的Idea中，选其中的一个PM想要完成的idea
	private static IdeaTask selectTask(PM[] pms, int workTime) {
		PriorityQueue<IdeaTask> pq = new PriorityQueue<>((x, y) -> {
			if (x.raiseTime == y.raiseTime || (x.raiseTime <= workTime && y.raiseTime <= workTime)) {
				if (x.timeCost != y.timeCost)
					return x.timeCost - y.timeCost;
				else
					return x.pmSeq - y.pmSeq;
			}
			if (x.raiseTime > workTime && y.raiseTime > workTime)
				return x.raiseTime - y.raiseTime;
			if (x.raiseTime > workTime)
				return 1;
			if (y.raiseTime > workTime)
				return -1;
			return 0;
		});
		for (int i = 1; i < pms.length; i++) {
			PM pm = pms[i];
			IdeaTask desiredTask = pm.mostDesiredTask(workTime);
			if (desiredTask != null)
				pq.offer(desiredTask);
		}
		IdeaTask task = pq.poll();
		while (!pq.isEmpty()) {
			IdeaTask tmp = pq.poll();
			pms[tmp.pmSeq].pq.offer(tmp);
		}
		return task;
	}

	private static List<IdeaTask> getTasks(int taskNum) {
		List<IdeaTask> tasks = new LinkedList<>();
		while (taskNum-- > 0) {
			tasks.add(new IdeaTask(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		return tasks;
	}

	private static PM[] initPM(int n, List<IdeaTask> tasks) {
		PM[] pms = new PM[n + 1];
		for (int i = 1; i <= n; i++)
			pms[i] = new PM();
		for (IdeaTask task : tasks) {
			pms[task.pmSeq].pq.offer(task);
		}
		return pms;
	}

	public static void main(String[] args) {
		int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();

		List<IdeaTask> tasks = getTasks(p);
		PM[] pms = initPM(n, tasks);

		PriorityQueue<Programmer> losersPq = new PriorityQueue<>(Comparator.comparingInt(x -> x.nextWorkTime));
		for (int i = 0; i < m; i++)
			losersPq.offer(new Programmer(0));
		while (true) {
			Programmer loser = losersPq.poll();
			IdeaTask task = selectTask(pms, loser.nextWorkTime);
			if (task == null)
				break;
			task.endTime = Integer.max(task.raiseTime, loser.nextWorkTime) + task.timeCost;
			loser.nextWorkTime = task.endTime;
			losersPq.offer(loser);
		}
		for (IdeaTask task : tasks) {
			System.out.println(task.endTime);
		}

	}
}
