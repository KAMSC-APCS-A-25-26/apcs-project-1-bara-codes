// Bara Omaira
// November 3rd, 2025
// 6th Period
// You are a lost explorer in the Great Pyramids of Giza trying to find your way out alive.
// Follow along with the story and make key decisions that determine your survival!

import java.util.Scanner;
import java.util.Random;
public class TextAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // replay loop for if the player wants to play again
        boolean playAgain = true;
        while (playAgain)
        {
            // Game variables:
            int health = 10;
            int score = 0;
            boolean hasTorch = false;
            boolean hasKey = false;
            boolean secretEnding = false;
            int scene = 0;
            boolean escaped = false;
            boolean dead = false;

            // Intro and title
            System.out.println("   \n" +
                    "              /=\\\\\n" +
                    "             /===\\ \\\n" +
                    "            /=====\\' \\\n" +
                    "           /=======\\'' \\\n" +
                    "          /=========\\ ' '\\\n" +
                    "         /===========\\''   \\\n" +
                    "        /=============\\ ' '  \\\n" +
                    "       /===============\\   ''  \\\n" +
                    "      /=================\\' ' ' ' \\\n" +
                    "     /===================\\' ' '  ' \\\n" +
                    "    /=====================\\' '   ' ' \\\n" +
                    "   /=======================\\  '   ' /\n" +
                    "  /=========================\\   ' /\n" +
                    " /===========================\\'  /\n" +
                    "/=============================\\/");

            System.out.println("\n========================================\n THE GREAT PYRAMID AND THE LOST EXPLORER\n========================================");
            System.out.println("You are an explorer who has gotten lost inside the Great Pyramid of Giza.");
            System.out.println("Your goal is to survive and escape. \n");

            // Scene 1: Entrance
            scene = 1;
            System.out.println("--- Scene " + scene + ":Entrance ---");
            System.out.println("You step into a chamber covered with sand and see two pathways: ");
            System.out.println("A) A narrow passage on the left lined with strange looking glyphs");
            System.out.println("B) A dark, wide corridor on the right that goes downward");
            String choice = "";
            // Input validation
            while (true) {
                System.out.print("Choose [A/B]: ");
                choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("a") || choice.equals("b"))
                {
                    break;
                }
                System.out.println("Invalid choice. Please choose A or B.");
            }

            // Major decision #1
            if (choice.equals("a"))
            {
                // The pathway on the left
                System.out.println("\nYou take the passage on the left. The air smells like old incense.");
                // Adds to score for exploring and displays it
                score =+ 5;
                System.out.println("Score +5 (now " + score + "). ");

                // Scene 2: Torch Room
                scene = 2;
                System.out.println("\n--- Scene " + scene + ": Torch Room ---");
                System.out.println("You find a section on the wall with a torch and a small amulet.");
                System.out.println("You only have room in your inventory for one of these items. ");
                System.out.println("A) Take the torch");
                System.out.println("B) Take the amulet");
                String choice2 = "";
                while (true)
                {
                    System.out.print("Choose [A/B]: ");
                    choice2 = sc.nextLine().trim().toLowerCase();
                    if (choice2.equals("a") || choice2.equals ("b"))
                    {
                        break;
                    }
                    System.out.println("Invalid choice. Please A or B. ");
                }

                if (choice2.equals("a"))
                {
                    hasTorch = true;
                    score =+ 3;
                    System.out.println("\nYou take the torch. You can now see better in the dark.");
                    System.out.println("Score +3 (now " + score + ").");
                }
                else
                {
                    // choosing the amulet increases your score because it is very cool
                    score += 7;
                    System.out.println("\nYou take the amulet and put it in your bag. It seems special.");
                    System.out.println("Score +7 (now " + score + ").");
                }

                // Scene 3: Chamber
                scene = 3;
                System.out.println("\n--- Scene " + scene + ": The Chamber ---");
                System.out.println("The path led to a chamber with a huge stone door and a grate. ");
                System.out.println("You can try to examine the door or the grate.");
                System.out.println("A) Inspect the stone door");
                System.out.println("B) Inspect the grate");
                String choice3 = "";
                while (true)
                {
                    System.out.print("Choose [A/B]: ");
                    choice3 = sc.nextLine().trim().toLowerCase();
                    if (choice3.equals("a") || choice3.equals ("b"))
                    {
                        break;
                    }
                    System.out.println("Invalid choice. Please choose A or B.");
                }

                if (choice3.equals("a"))
                {
                    System.out.println("\nThe door has a rusted lock. You need a key or something to pick it.");
                    // You can try to pick the lock (mini-challenge)
                    System.out.println("You can try to pick the lock (3 attempts) or look for a key later.");
                    System.out.println("A) Try to pick the lock");
                    System.out.println("B) Look for a key");
                    String lockChoice = "";
                    while (true)
                    {
                        System.out.print("Choose [A/B]: ");
                        lockChoice = sc.nextLine().trim().toLowerCase();
                        if (lockChoice.equals("a") || lockChoice.equals("b"))
                        {
                            break;
                        }
                        System.out.println("Invalid choice. Please choose A or B.");
                    }

                    if (lockChoice.equals("a"))
                    {
                        // mini-challenge: lock picking
                        System.out.println("\nYou attempt to pick the lock. It is a difficult job.");
                        // generates secret random number from 1-5
                        int secret = rand.nextInt(5) + 1;
                        boolean picked = false;
                        for (int attempt = 1; attempt <= 3; attempt ++) {
                            System.out.print("Attempt " + attempt + " - guess the tumblers (1-5): ");
                            String x = sc.nextLine().trim();
                            // validates the input
                            while (!x.matches("[1-5]"))
                            {
                                System.out.println("Invalid attempt. Please enter a number 1-5: ");
                                x = sc.nextLine().trim();
                            }
                            int guess = Integer.parseInt(x);
                            if (guess == secret)
                            {
                                picked = true;
                                System.out.println("Click! You hear the lock release.");
                                hasKey = true;
                                score += 10;
                                System.out.println("Score +10 (now " + score + ").");
                                break;
                            }
                            else {
                                System.out.println("It didn't work. The door is still locked. ");
                                // Loses health after failing the lock-picking challenge
                                health -= 1;
                                System.out.println("You hurt your hands. Health -1 (now " + health + ").");
                            }
                        }
                        if (!picked)
                        {
                            System.out.println("\nYou failed to pick the lock.");
                        }
                        else
                        {
                            System.out.println("\nYou decide to search further into the pyramid for a key.");
                        }
                    }
                    else
                    {
                        // inspecting the gate
                        System.out.println("\nYou kneel by the grate and peer through into a dark pit.");
                        if (hasTorch)
                        {
                            System.out.println("With your torch you see a key at the bottom.");
                            hasKey = true;
                            score =+ 8;
                            System.out.println("You fish it out with your rope. Key obtained. Score +8 (now " + score + ").");
                        }
                        else
                        {
                            System.out.println("It's too dark to see anything in the grate.");
                            System.out.println("You need a torch before trying this.");
                        }
                    }

                    // Scene 4: After trying to open the door
                    scene = 4;
                    System.out.println("\n--- Scene " + scene + ": The Descent ---");
                    System.out.println("A hallway goes down to two doors: one with a carved hawk on it, and one with nothing on it.");
                    System.out.println("A) Hawk door");
                    System.out.println("B) Plain door");
                    String choice4 = "";
                    while (true)
                    {
                        System.out.print("Choose [A/B]: ");
                        choice4 = sc.nextLine().trim().toLowerCase();
                        if (choice4.equals("a") || choice4.equals("b"))
                        {
                            break;
                        }
                        System.out.println("Invalid choice. Please choose A or B.");
                    }

                    if (choice4.equals("a"))
                    {
                        System.out.println("\nThe hawk door opens into the Hall of Traps.");
                        // trap affects health
                        health -= 3;
                        System.out.println("A pressure plate trips! You dodge but are grazed by darts. Health -3 (now " + health + ").");
                        score += 5;
                        System.out.println("You find a shard of pottery with symbols. Score +5 (now " + score + ").");
                    } else {
                        System.out.println("\nThe plain door opens into a quiet room filled with sand. It's safe... for now.");
                        System.out.println("You rest and recover 2 health.");
                        health += 2;
                        System.out.println("Health +2 (now " + health + ").");
                    }

                    // Scene 5: Gate Chamber
                    scene = 5;
                    System.out.println("\n--- Scene " + scene + ": Gate Chamber ---");
                    System.out.println("You reach a massive gate with an intricate lock. A plaque reads: 'Only the lit shall pass.'");
                    System.out.println("You can try to open the gate or inspect the side wall for hidden passages.");
                    System.out.println("A) Try to open the gate");
                    System.out.println("B) Inspect the side wall");
                    String gateChoice = "";
                    while (true) {
                        System.out.print("Choose [A/B]: ");
                        gateChoice = sc.nextLine().trim().toLowerCase();
                        if (gateChoice.equals("a") || gateChoice.equals("b"))
                        {
                            break;
                        }
                        System.out.println("Invalid choice. Please choose A or B. ");
                    }

                    if (gateChoice.equals("a")) {
                        // Gate opens only if hasKey OR (hasTorch and amulet?)
                        if (hasKey) {
                            System.out.println("\nYou use the key. The lock turns and the gate slides open.");
                            score += 10;
                            System.out.println("Score +10 (now " + score + ").");
                            escaped = true;
                        } else if (hasTorch) {
                            // lit will pass - torch helps reveal hidden latch
                            System.out.println("\nWith the torch lit you find a hidden latch warmed by some ancient mechanism.");
                            System.out.println("You pull it and the gate creaks open.");
                            score += 6;
                            System.out.println("Score +6 (now " + score + ").");
                            escaped = true;
                        } else {
                            System.out.println("\nThe gate won't budge. The plaque's riddle suggests light is needed.");
                            System.out.println("You should find something to light the mechanism.");
                        }
                    } else {
                        System.out.println("\nYou press along the wall and reveal a narrow crawlspace.");
                        System.out.println("Crawl through? [Y/N]");
                        String crawl = "";
                        while (true) {
                            System.out.print("Choose [Y/N]: ");
                            crawl = sc.nextLine().trim().toLowerCase();
                            if (crawl.equals("y") || crawl.equals("n"))
                            {
                                break;
                            }
                            System.out.println("Please type Y or N.");
                        }
                        if (crawl.equals("y")) {
                            // secret path - leads to secret chamber (alternate ending possibility)
                            System.out.println("\nYou crawl through and discover a small hidden chamber filled with golden relics.");
                            score += 20;
                            secretEnding = true;
                            System.out.println("Score +20 (now " + score + ").");
                            // But this room is fragile - risk
                            System.out.println("As you collect a relic, the ceiling trembles...");
                            int tremor = rand.nextInt(10);
                            if (tremor < 4) {
                                System.out.println("The ceiling collapses partially and you are trapped!");
                                dead = true;
                                System.out.println("You are buried by rubble. You did not make it out.");
                            } else {
                                System.out.println("You slip out the way you came, relics in hand, and find a chute that leads up toward the surface.");
                                escaped = true;
                            }
                        } else {
                            System.out.println("You decide not to crawl. You return to the gate.");
                        }
                    }

                } else { // Right path from Scene 1
                    // downward path
                    System.out.println("\nYou take the darker, wider corridor downward. The air grows colder.");
                    score += 2;
                    System.out.println("Score +2 (now " + score + ").");

                    // Scene 2: Pit and the Rope
                    scene = 2;
                    System.out.println("\n--- Scene " + scene + ": Pit & Rope ---");
                    System.out.println("You find a pit with a rope ladder and a rusty hook. Nearby: a faded mural.");
                    System.out.println("A) Climb down the rope ladder");
                    System.out.println("B) Take the hook and continue along the corridor");
                    String choice6 = "";
                    while (true) {
                        System.out.print("Choose [A/B]: ");
                        choice6 = sc.nextLine().trim().toLowerCase();
                        if (choice6.equals("a") || choice6.equals("b")) break;
                        System.out.println("Please type A or B.");
                    }

                    if (choice2.equals("a")) {
                        System.out.println("\nYou climb down. At the bottom is a chamber with skeletons and an intact torch bracket.");
                        System.out.println("Do you take the torch from the bracket? [Y/N]");
                        String takeTorch = "";
                        while (true) {
                            System.out.print("Choose [Y/N]: ");
                            takeTorch = sc.nextLine().trim().toLowerCase();
                            if (takeTorch.equals("y") || takeTorch.equals("n")) break;
                            System.out.println("Please type Y or N.");
                        }
                        if (takeTorch.equals("y")) {
                            hasTorch = true;
                            score += 4;
                            System.out.println("You take the torch. Score +4 (now " + score + ").");
                        } else {
                            System.out.println("You leave the torch. It might be important later.");
                        }

                        // Scene 3: The Sarcophagus Room
                        scene = 3;
                        System.out.println("\n--- Scene " + scene + ": Sarcophagus Room ---");
                        System.out.println("In the center stands a sarcophagus with a carved scarab. There's a narrow passage beyond it.");
                        System.out.println("A) Open the sarcophagus");
                        System.out.println("B) Move past the sarcophagus into the narrow passage");
                        String sarc = "";
                        while (true) {
                            System.out.print("Choose [A/B]: ");
                            sarc = sc.nextLine().trim().toLowerCase();
                            if (sarc.equals("a") || sarc.equals("b")) break;
                            System.out.println("Please type A or B.");
                        }

                        if (sarc.equals("a")) {
                            System.out.println("\nYou lift the lid. Inside lies a jewel key!");
                            hasKey = true;
                            score += 12;
                            System.out.println("Key obtained. Score +12 (now " + score + ").");
                        } else {
                            System.out.println("\nYou slip past the sarcophagus and the narrow passage leads upward.");
                            // but it's dark—requires torch to proceed safely
                            if (!hasTorch) {
                                System.out.println("It's pitch black. You stumble and cut your arm on a shard.");
                                health -= 2;
                                System.out.println("Health -2 (now " + health + ").");
                            } else {
                                System.out.println("With your torch you navigate easily.");
                            }
                        }

                    } else { // choice2 == b
                        System.out.println("\nYou take the hook and continue. The corridor narrows then opens into a chamber with murals of stars.");
                        score += 4;
                        System.out.println("You notice a mural depicting a hidden door at the base of a statue.");
                        // Scene 3: The Puzzle
                        scene = 3;
                        System.out.println("\n--- Scene " + scene + ": Statue Puzzle ---");
                        System.out.println("There are three statues. One must be pushed to reveal a door. Which one? (1/2/3)");
                        String statue = "";
                        while (true) {
                            System.out.print("Choose [1/2/3]: ");
                            statue = sc.nextLine().trim();
                            if (statue.equals("1") || statue.equals("2") || statue.equals("3")) break;
                            System.out.println("Please type 1, 2, or 3.");
                        }
                        // nested decision
                        if (statue.equals("2")) {
                            System.out.println("\nThe statue moves and a hidden door reveals a sunlit chute upward!");
                            score += 15;
                            System.out.println("Score +15 (now " + score + ").");
                            escaped = true;
                        } else {
                            System.out.println("\nThe statue is stuck. A trap releases sand from above!");
                            health -= 4;
                            System.out.println("You are buried briefly. Health -4 (now " + health + ").");
                            if (health <= 0) {
                                dead = true;
                                System.out.println("You suffocate in shifting sand.");
                            } else {
                                System.out.println("You dig out and notice a faint passage leading to a gate with a riddle.");
                                // gate later might be opened if player has key or torch
                            }
                        }
                    }

                    // continue right-path flow to Gate Chamber (scene 5)
                    scene = 5;
                    if (!escaped && !dead) {
                        System.out.println("\n--- Scene " + scene + ": Gate At The End ---");
                        System.out.println("You reach a heavy gate with the same inscription: 'Only the lit shall pass.'");
                        if (hasKey) {
                            System.out.println("Fortunately you have a key. You can try it or search for another way.");
                        } else {
                            System.out.println("You don't have a key visible.");
                        }
                        System.out.println("A) Use key (if you have one)");
                        System.out.println("B) Look for a way to light something or another path");
                        String x2 = "";
                        while (true) {
                            System.out.print("Choose [A/B]: ");
                            x2 = sc.nextLine().trim().toLowerCase();
                            if (x2.equals("a") || x2.equals("b")) break;
                            System.out.println("Invalid choice. Please choose A or B.");
                        }

                        if (x2.equals("a")) {
                            if (hasKey) {
                                System.out.println("\nYou unlock the gate with your key and it opens onto the desert outside.");
                                score += 10;
                                escaped = true;
                            } else {
                                System.out.println("\nYou don't actually have a key. You fumble and waste time.");
                                health -= 1;
                                System.out.println("Health -1 (now " + health + ").");
                            }
                        } else {
                            if (hasTorch) {
                                System.out.println("\nYou light the torch and the gate's inscription glows. A hidden mechanism releases and the gate opens.");
                                escaped = true;
                                score += 6;
                            } else {
                                System.out.println("\nYou search for another way but slip into a narrow pit and twist your ankle.");
                                health -= 2;
                                System.out.println("Health -2 (now " + health + ").");
                            }
                        }
                    }
                } // end major branch (left/right)

                // If health reached zero, the player dies
                if (health <= 0 && !dead) {
                    dead = true;
                    System.out.println("\nYour injuries are too severe. You collapse and cannot continue.");
                }

                // Additional ending: If the player found many relics and has high score, secret ending
                if (!escaped && !dead && score >= 30 && secretEnding) {
                    System.out.println("\nBecause of the relics you collected, a hidden mechanism triggers and reveals a private exit.");
                    escaped = true;
                }

                // ---------- Final Scene: Outcome summary ----------
                System.out.println("\n========================================");
                System.out.println("  FINAL OUTCOME");
                System.out.println("========================================");
                System.out.println("Health: " + health);
                System.out.println("Score: " + score);
                System.out.println("Torch: " + (hasTorch ? "Yes" : "No"));
                System.out.println("Key: " + (hasKey ? "Yes" : "No"));
                System.out.println();

                if (dead) {
                    // Losing ending - dead
                    System.out.println("Ending: Trapped Below");
                    System.out.println("Your journey ends in the ancient stone. The pyramid keeps its secrets.");
                } else if (escaped && score >= 35) {
                    // Secret ending
                    System.out.println("Ending: Secret Legacy");
                    System.out.println("You come out of the pyramid with treasures and knowledge. Your discovery will rewrite history!");
                } else if (escaped) {
                    // Winning ending
                    System.out.println("Ending: Narrow Escape");
                    System.out.println("You find your way out into the bright Egyptian sun. You survived and lived to tell the tale.");
                } else {
                    // Another losing ending
                    System.out.println("Ending: Alive... For Now");
                    System.out.println("You are alive but trapped in a sealed chamber. Rescue may come... or may not.");
                }

                // Replay prompt
                String again = "";
                while (true) {
                    System.out.print("\nPlay again? [Y/N]: ");
                    again = sc.nextLine().trim().toLowerCase();
                    if (again.equals("y") || again.equals("n")) break;
                    System.out.println("Please type Y or N.");
                }
                if (again.equals("y")) {
                    playAgain = true;
                    System.out.println("\nRestarting the adventure\n");
                } else {
                    playAgain = false;
                    System.out.println("\nThanks for playing The Great Pyramid: Lost Explorer. Goodbye!");
                }
            } // end replay loop

            sc.close();
        }
    }
}
