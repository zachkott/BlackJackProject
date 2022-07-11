package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Guest;

public class BlackJackApp {
	Scanner sc = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Guest player = new Guest();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();

		app.runApp();
	}

	public void runApp() {
		appMenu();
		boolean keepGoing = true;

		do {
			System.out.println("Please choose an option from the menu.");
			int menuOption = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menuOption) {
			case 1:
				displayRules();
				System.out.println();
				break;

			case 2:
				getName();
				playGame();
				System.out.println();

			case 3:
				quitApp();
				break;

			default:
				System.out.println("Invalid input. Please try again");
				break;

			}
			appMenu();

		} while (keepGoing);

	}

	public void displayRules() {
		System.out.println("Welcome to Zach’s Blackjack Table. Blackjack is a relatively simple game \n"
				+ "with only a few rules. The basic premise of the game is that you want to have a \n"
				+ "hand value that is closer to 21 than that of the dealer, without going over 21. \n"
				+ "Other players at the table are of no concern. Your hand competes only against the \n"
				+ "hand of the dealer. Every player will initially be dealt 2 cards. After you have \n"
				+ "been dealt your cards you may either choose to hit or stand. If you choose to hit \n"
				+ "you will be given an additional card. If you choose to hit and the value of your \n"
				+ "hand exceeds 21, you bust and the dealer wins. If you choose to stand you will \n"
				+ "keep your current hand and it will be the dealers turn. If neither hand is equal \n"
				+ "to 21 the winning hand will be the hand with the closest value to 21. Now that \n"
				+ "you know how to play, let’s get in there and gamble!");

	}

	public void getName() {
		System.out.println("Welcome to Zach's Blackjack table");
		System.out.println("Before I take all of your money, what should I call ya?");
		String name = sc.nextLine();

		System.out.println("Alright " + name + ". Let's play some Blackjack!\n");
	}

	public void playGame() {

		System.out.println("Shuffling the deck...");
		dealer.shuffleDeck();
		System.out.println("Dealing cards...\n");

		System.out.println("The first card for the dealer is facing down.\n");
		dealer.getHand().addCard(dealer.deal());
		dealer.showHand();
		dealer.getHand().addCard(dealer.deal());

		System.out.println("      ");

		player.getHand().addCard(dealer.deal());
		player.getHand().addCard(dealer.deal());

		System.out.println("     ");

		if (player.getHand() instanceof BlackJackHand && ((BlackJackHand) player.getHand()).isBlackjack()) {
			System.out.println("Blackjack! You win!");
		} else if (dealer.getHand() instanceof BlackJackHand && ((BlackJackHand) dealer.getHand()).isBlackjack()) {
			System.out.println("Blackjack! Dealer wins");
		} else if (player.getHand() instanceof BlackJackHand && ((BlackJackHand) player.getHand()).isBlackjack()
				&& dealer.getHand() instanceof BlackJackHand && ((BlackJackHand) dealer.getHand()).isBlackjack()) {
			System.out.println("Push! You and the dealer both have blackjack!");
		} else {

			playersCards();
			dealersCards();
		}
		gameResult();

		player.getHand().clear();
		dealer.getHand().clear();
		keepPlaying();

	}

	public void gameResult() {

		if (player.getHand() instanceof BlackJackHand && ((BlackJackHand) player.getHand()).isBust()) {
			System.out.println("You Lose!");

		}

		// Added logic to determine the winner in every scenario (There's got to be an
		// easier way to do this)
		if (player.getHand() instanceof BlackJackHand && ((BlackJackHand) player.getHand()).isBlackjack()) {

			System.out.println("You win!");

		}

		if (dealer.getHand() instanceof BlackJackHand && ((BlackJackHand) dealer.getHand()).isBlackjack()) {
			System.out.println("Dealer wins.");

		}

		if (player.handTotal() > dealer.handTotal() && player.handTotal() <= 21) {
			System.out.println("Your hand value is higher than the dealer's!");

		}
		if (player.handTotal() > dealer.handTotal() && !player.getHand().isBust()) {
			System.out.println("You win!");
		}
		if (player.handTotal() < dealer.handTotal() && !dealer.getHand().isBust()) {
			System.out.println("Dealer Wins!");
		}
		if (dealer.handTotal() > player.handTotal() && !dealer.getHand().isBust()) {
			System.out.println("Dealer Wins!");
		}

		if (dealer.handTotal() < player.handTotal() && player.getHand().isBust() && !dealer.getHand().isBust()) {
			System.out.println("Dealer wins!");
		}
		if (player.handTotal() == dealer.handTotal()) {
			System.out.println("It's a tie!");
		}

	}

	public void dealersCards() {

		dealer.showHand();

		if (dealer.handTotal() >= 17) {
			System.out.println("Dealer stands.");
			;
		}
		while (dealer.handTotal() < 17) {
			System.out.println("Dealer hits.");
			dealer.hit();
			dealer.showHand();

			if (dealer.getHand() instanceof BlackJackHand && ((BlackJackHand) dealer.getHand()).isBust()) {
				System.out.println("Dealer bust!");
			}

			if (dealer.handTotal() > player.handTotal() && !dealer.getHand().isBust()) {
				System.out.println("Dealer wins.");
			}
			if (player.handTotal() < dealer.handTotal() && dealer.getHand().isBust()) {
				System.out.println("You Win!");
			}
		}

	}

	public void playersCards() {
		int hitOrStand = 0;
		player.showHand();

		do {

			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Hit \n2. Stand");
			hitOrStand = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (hitOrStand) {
			case 1:
				dealer.hit(player);
				player.showHand();
				break;
			case 2:

				break;
			default:
				System.out.println("Invalid response. \n 1. Hit \n 2. Stand");
				break;

			}
		} while (player.handTotal() < 21 && hitOrStand != 2);

		if (player.getHand() instanceof BlackJackHand && ((BlackJackHand) player.getHand()).isBust()) {
			System.out.println("Bust! Better luck next time! \n");

		}

	}

	public void keepPlaying() {

		try {
			int choice = 0;
			System.out.println("Would you like to continue playing? \n 1. Yes \n 2. No");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				playGame();
				break;

			case 2:
				quitApp();
				break;

			default:
				System.out.println("Invalid response. Try again");
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid response. Try again");
			System.out.println();
			sc.nextLine();
		}
		keepPlaying();
	}

	public void appMenu() {
		System.out.println("///////////////////////////////////////////////////////");
		System.out.println("/                                                     /");
		System.out.println("/                  - Main Menu -                      /");
		System.out.println("/                                                     /");
		System.out.println("/   1: How to play.                                   /");
		System.out.println("/   2: Play Black Jack.                               /");
		System.out.println("/   3: Quit program.                                  /");
		System.out.println("/                                                     /");
		System.out.println("///////////////////////////////////////////////////////");
		System.out.println();

	}

	public void quitApp() {
		System.out.println("Thank you for stopping by Zach's Blackjack Table. Have a wonderful day!");
		System.exit(0);
	}
}
