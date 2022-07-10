package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Guest;

public class BlackJackApp {
	Scanner sc = new Scanner(System.in);
	private Deck bjDeck = new Deck();
	private BlackJackHand hand;

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

	public void playGame() {
		Dealer dealer = new Dealer();
		Guest player = new Guest();

		boolean keepItRollin = true;

		System.out.println("Welcome to Zach's Blackjack table");
		System.out.println("Before I take all of your money, what should I call ya?");
		String name = sc.nextLine();

		System.out.println("Alright " + name + ". Let's play some Blackjack!");

//		do {
			System.out.println("Shuffling the deck...");
			dealer.shuffleDeck();
			System.out.println("Dealing cards...");

			dealer.getHand().addCard(dealer.deal());
			dealer.getHand().addCard(dealer.deal());

			System.out.println("      ");

			player.getHand().addCard(dealer.deal());
			player.getHand().addCard(dealer.deal());

			System.out.println("     ");

			player.showHand();
			dealer.showHand();

			System.out.println();
			
			
//		} while (keepItRollin);

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
		System.out.println("Thank you come again");
		System.exit(0);
	}
}
