/**
 * 
 */
package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zolanunu
 * 
 */
public class SoccerPlayer {
	/**
	 * 
	 * 大学生足协决定举办全国�?�的大学生足球赛，由每个学校派遣�?支队伍代表该校参�?
	 * 比赛分区分为几个赛区进行，最终的总决赛中，将有不超过n支队伍参加�?�经过激烈的角�?�，有机会参与�?�决赛的队伍已经决出�?
	 * 协会对比赛的规则进行了调整，以便使得比赛更具有观赏�?��?? 1. 总决赛的参赛队伍为n支，n为偶数； 2. 进入�?1/2的队伍才有资格进入淘汰赛�?
	 * 3. 队伍按积分排名，具体规则为：胜一场积3分；平一场积1分；负一场积0分�??
	 * 队伍首先按积分降序排列，积分相同按净胜球数降序排列，仍然相同的按进球数降序排列�?? 4. 基于上述规则，尚未出现有排名歧义的情况发生�?? 输入�?
	 * 测试数据有多组，每组测试数据的第�?行为�?个整数n�?1=< n <=50），为参与�?�决赛的球队数，随后的n行为球队的名字，
	 * 由不超过30个的大小写拉丁字母构成�?�随后的n*(n-1)/2行为赛事的开展情况，每行的格式为name1-name2 num1:num2�?
	 * 表示两支队伍的比分情况（1=<num1, num2<=100）�?�确保不会有两支队伍同名，也不会出现队伍自己通自己比赛的情况，且每场比赛仅出现一次�??
	 * 输出�? 对每组测试数据，输出n/2行，为按字母序排列的进入淘汰赛的n/2支队伍的名单，每个名字在单独的行中输出�??
	 * */
	class Team {
		String name;
		int grade;
		int realwin;
		int in;

		public Team(String name, int grade, int realin, int in) {
			this.name = name;
			this.grade = grade;
			this.realwin = realin;
			this.in = in;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getRealwin() {
			return realwin;
		}

		public void setRealwin(int realwin) {
			this.realwin = realwin;
		}

		public int getIn() {
			return in;
		}

		public void setIn(int in) {
			this.in = in;
		}

	}

	public ArrayList<Character> winner() {
		return null;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SoccerPlayer main = new SoccerPlayer();
		while (scanner.hasNext()) {
			String nString = scanner.nextLine();
			int n = Integer.valueOf(nString);
			Team[] win = new Team[n];
			TreeMap<String, Team> map = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String cname = scanner.nextLine();
				Team team = main.new Team(cname, 0, 0, 0);
				map.put(cname, team);
			}
			int len = (n * (n - 1)) / 2;// 对所有的比赛结果进行处理
			for (int i = 0; i < len; i++) {
				String[] strings = scanner.nextLine().split(" ");
				String[] name = strings[0].split("-");
				String cname1 = name[0];
				String cname2 = name[1];
				String[] grad = strings[1].split(":");
				int c1 = Integer.valueOf(grad[0]);
				int c2 = Integer.valueOf(grad[1]);
				int c = c1 - c2; // 比分差距
				int grade1 = 0; // 得分
				int realwin1 = 0; // �?胜球�?
				int in1 = c1; // 进球�?
				int grade2 = 0;
				int realwin2 = 0;
				int in2 = c2;
				if (c == 0) { // 平局
					grade1 = 1;
					grade2 = 1;
				} else if (c > 0) {
					grade1 = 3;
					realwin1 = c;

				} else {
					grade2 = 3;
					realwin2 = c2 - c1;
				}
				// 设置得分，净胜球数，进球�?
				Team team = map.get(cname1);
				team.setGrade(team.grade + grade1);
				team.setIn(team.in + in1);
				team.setRealwin(team.realwin + realwin1);
				map.put(cname1, team);

				Team team2 = map.get(cname2);
				team2.setGrade(team2.grade + grade2);
				team2.setIn(team2.in + in2);
				team2.setRealwin(team2.realwin + realwin2);
				map.put(cname2, team2);
			}
			int i = 0;
			for (String key : map.keySet()) {
				win[i++] = map.get(key);
			}
			// 自定义排序比较器。排序规则：
			// 首先按照积分，其次净胜球，最后进球数
			Arrays.sort(win, new Comparator<Team>() {
				public int compare(Team o1, Team o2) {
					int grade = o2.grade - o1.grade;
					int realwin = o2.realwin - o1.realwin;
					int in = o2.in - o1.in;
					if (grade != 0)
						return grade;
					else if (realwin != 0)
						return realwin;
					else
						return in;
				}
			});
			String[] name = new String[n / 2];
			for (i = 0; i < n / 2; i++)
				name[i] = win[i].name;
			Arrays.sort(name);// 对球队名字按字典序输�?
			for (i = 0; i < n / 2; i++)
				System.out.println(name[i]);
		}

	}

}
