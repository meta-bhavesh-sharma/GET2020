/*
 *Job Scheduling Using First Serve First Come Approch
 *Methods Imported for calculations for Waiting time,Turn around time,Completetion time,avg waiting time ,avg turn arround time 
input[x][1]=burst time
input[x][1]=arival time
 */
import java.util.*;

class JobScheduler {
	// to sort process based on arrival time
	void sort(int[][] input, int n) {
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (input[j][0] > input[j + 1][0]) {
					temp = input[j][0];
					input[j][0] = input[j + 1][0];
					input[j + 1][0] = temp;
					temp = input[j][1];
					input[j][1] = input[j + 1][1];
					input[j + 1][1] = temp;
				}
			}
		}
	}

	/** finding waiting time
	 * 
	 * @param input 2 dimentional array containing arival and burst time of processes
	 * @param wt waiting time array
	 * @param n number of process
	 */
	void findWaitingTime(int input[][], int wt[], int n) {
		// service time = total time before process execution starts
		int service_time[] = new int[n];
		service_time[0] = input[0][0];
		wt[0] = 0;
		for (int i = 1; i < n; i++) {
			service_time[i] = service_time[i - 1] + input[i - 1][1];
			wt[i] = service_time[i] - input[i][0];
			if (wt[i] < 0)
				wt[i] = 0;
		}
	}

	/** for turn arround time
	 * 
	 * @param input input 2 dimentional array containing arival and burst time of processes
	 * @param wt wt waiting time array
	 * @param tat turn around time
	 * @param n n number of process
	 */
	void findTurnAroundTime(int input[][], int wt[], int tat[], int n) {
		for (int i = 0; i < n; i++)
			tat[i] = input[i][1] + wt[i];
	}

	/** for completetion time
	 * 
	 * @param input input 2 dimentional array containing arival and burst time of processes
	 * @param tat turn around time
	 * @param n n number of process
	 * @param ct completetion time 
	 */
	void findCompletetionTime(int input[][], int tat[], int ct[], int n) {
		for (int i = 0; i < n; i++) {
			ct[i] = tat[i] + input[i][0];
		}
	}

	/** to find average Waiting time and maximum waiting time in queue
	 * 
	 * @param wt waiting time
	 * @param n number of process
	 */
	void findAvgWaitingTime(int[] wt, int n) {
		int w = 0;
		int p = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + wt[i];
			if (wt[i] > w) {
				w = wt[i];
				p = i + 1;
			}
		}
		System.out.println("Average Waiting time is" + ((float) sum / (float) n));
		System.out.println("Maximum Waiting time in queue is of process no " + p + " and waiting time is " + w);
	}

	/** for exception handeled iput
	 * 
	 * @return intiger which got from valid input
	 */
	public int input() {
		int n;
		Scanner sc = new Scanner(System.in);
		try {
			n = sc.nextInt();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Please enter valid number");
			n = input();
		}
		return n;
	}

	// driver code
	/*
	 * input specifications number of process,and process details arrivaltime
	 * and burst time output specifications waiting time,turn around
	 * time,completetion time,avg waiting time,maximum waiting time in queue
	 */
	public static void main(String args[]) {
		JobScheduler j1 = new JobScheduler();
		System.out.println("Please enter no of process");
		int n;
		n = j1.input();
		System.out
				.println("now enter arival time and burst time for all processes");
		int[][] input = new int[4][2];
		for (int i = 0; i < n; i++) {
			System.out
					.println("enter arival time and burst time for  processe  " + (i + 1));
			for (int j = 0; j < 2; j++)
				input[i][j] = j1.input();
		}
		j1.sort(input, n);
		int[] tat = new int[n];
		int[] wt = new int[n];
		int[] ct = new int[n];
		j1.findWaitingTime(input, wt, n);
		j1.findTurnAroundTime(input, wt, tat, n);
		j1.findCompletetionTime(input, tat, ct, n);
		System.out.println("arrival time " + "burst time " + "waiting time " + "turn arround time " + "completetion time ");
		for (int i = 0; i < n; i++) {
			System.out.println(input[i][0] + "		" + input[i][1] + "		" + wt[i]+ "		" + tat[i] + "		" + ct[i]);
		}
		j1.findAvgWaitingTime(wt, n);
	}
}