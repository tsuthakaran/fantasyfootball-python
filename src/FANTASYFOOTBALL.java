import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class FANTASYFOOTBALL {
    public static String getName(teams t) {
        return t.name;
    }

    public static int getPlayed(teams t) {
        return t.played;
    }

    public static int getWins(teams t) {
        return t.wins;
    }

    public static int getDraws(teams t) {
        return t.draws;
    }

    public static int getLosses(teams t) {
        return t.losses;
    }

    public static int getGoalsFor(teams t) {
        return t.goalsFor;
    }

    public static int getGoalsAgainst(teams t) {
        return t.goalsAgainst;
    }

    public static int getPoints(teams t) {
        return t.points;
    }

    public static void updateStats(teams homeTeam, teams awayTeam, int homeScore, int awayScore) {
        homeTeam.played++;
        awayTeam.played++;
        homeTeam.goalsFor = homeTeam.goalsFor + homeScore;
        awayTeam.goalsAgainst = awayTeam.goalsAgainst + homeScore;
        homeTeam.goalsAgainst = homeTeam.goalsAgainst + awayScore;
        awayTeam.goalsFor = awayTeam.goalsFor + awayScore;

        if (homeScore > awayScore) {
            homeTeam.wins++;
            homeTeam.points += 3;
            awayTeam.losses++;
        } else if (homeScore < awayScore) {
            awayTeam.wins++;
            awayTeam.points += 3;
            homeTeam.losses++;
        } else {
            homeTeam.draws++;
            awayTeam.draws++;
            homeTeam.points++;
            awayTeam.points++;
        }
    }

    public static void setTeamNames(teams[] team, String[] teamNames, int i) {
        team[i].name = teamNames[i];
    }

    public static teams whatTeam() {
        System.out.println("Hi. Welcome to fantasy football!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What team would you like to manage?");
        String teamName = scanner.nextLine();

        teams team = new teams();
        team.name = teamName;

        System.out.println("Congratulations on managing " + teamName + ".");
        System.out.println();
        System.out.println();

        return team;
    }

    public static void initialiseSquads(teams[] team, int i, String p0, String p1, String p2, String p3, String p4,
            String p5, String p6, String p7, String p8, String p9, String p10) {
        team[i].player = new String[] { p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 };
    }

    public static String[] setManagingTeam() {
        Scanner scanner = new Scanner(System.in);
        String[] position = new String[11];
        String[] player = new String[11];
        position[0] = "Striker";
        position[1] = "Right Winger";
        position[2] = "Left Winger";
        position[3] = "Attacking Midfielder";
        position[4] = "Box to Box Midfielder";
        position[5] = "Attacking Full Back";
        position[6] = "Defensive Midfielder";
        position[7] = "Defensive Full Back";
        position[8] = "Left Centre Back";
        position[9] = "Right Centre Back";
        position[10] = "Goalkeeper";

        System.out.println("Please select your XI:");
        for (int i = 0; i < 11; i++) {
            System.out.println("Who is your " + position[i] + "?");
            player[i] = scanner.nextLine();
        }
        return player;
    }

    public static void setSquads(teams[] team) {
        String[] player;
        player = setManagingTeam();
        System.out.println();
        initialiseSquads(team, 0, player[0], player[1], player[2], player[3], player[4], player[5], player[6],
                player[7],
                player[8], player[9], player[10]);
        initialiseSquads(team, 1, "Rasmus Højlund", "Marcus Rashford", "Bruno Fernandes", "Alejandro Garnacho",
                "Casemiro", "Luke Shaw", "Raphaël Varane", "Aaron Wan-Bissaka", "Kobbie Mainoo", "Lisandro Martínez",
                "André Onana");
        initialiseSquads(team, 2, "Erling Haaland", "Julián Álvarez", "Jeremy Doku", "Kevin De Bruyne", "Rodri",
                "Bernardo Silva", "Kyle Walker", "Rúben Dias", "Joško Gvardiol", "Nathan Aké", "Ederson");
        initialiseSquads(team, 3, "Mohamed Salah", "Diogo Jota", "Darwin Núñez", "Dominik Szoboszlai", "Curtis Jones",
                "Alexis Mac Allister", "Trent Alexander-Arnold", "Virgil van Dijk", "Andrew Robertson",
                "Ibrahima Konaté", "Alisson");
        initialiseSquads(team, 4, "Son Heung-min", "Dejan Kulusevski", "James Maddison", "Brennan Johnson",
                "Pedro Porro", "Destiny Udogie", "Pape Matar Sarr", "Yves Bissouma", "Micky van de Ven",
                "Cristian Romero", "Guglielmo Vicario");
        initialiseSquads(team, 5, "Christopher Nkunku", "Raheem Sterling", "Cole Palmer", "Reece James", "Levi Colwill",
                "Conor Gallagher", "Enzo Fernández", "Moisés Caicedo", "Thiago Silva", "Levi Colwill",
                "Robert Sánchez");
        initialiseSquads(team, 6, "Kylian Mbappé", "Gonçalo Ramos", "Ousmane Dembélé", "Warren Zaire-Emery",
                "Achraf Hakimi", "Vitinha", "Nuno Mendes", "Manuel Ugarte Ribeiro", "Marquinhos", "Milan Škriniar",
                "Gianluigi Donnarumma");
        initialiseSquads(team, 7, "Wissam Ben Yedder", "Folarin Balogun", "Aleksandr Golovin", "Takumi Minamino",
                "Krépin Diatta", "Youssouf Fofana", "Denis Zakaria", "Ismail Jakobs", "Wilfried Singo",
                "Soungoutou Magassa", "Philipp Köhn");
        initialiseSquads(team, 8, "Steven Bergwijn", "Brian Brobbey", "Chuba Akpom", "Steven Berghuis",
                "Branco van den Boomen", "Kristian Nökkvi Hlynsson", "Jorrel Hato", "Kenneth Taylor", "Devyne Rensch",
                "Josip Šutalo", "Jay Gorter");
        initialiseSquads(team, 9, "Julian Brandt", "Donyell Malen", "Marco Reus", "Karim Adeyemi", "Julian Ryerson",
                "Emre Can", "Marcel Sabitzer", "Mats Hummels", "Nico Schlotterbeck", "Niklas Süle", "Gregor Kobel");
        initialiseSquads(team, 10, "Victor Boniface", "Álex Grimaldo", "Jonas Hofmann", "Florian Wirtz",
                "Jeremie Frimpong", "Exequiel Palacios", "Jonathan Tah", "Odilon Kossonou", "Granit Xhaka",
                "Edmond Tapsoba", "Lukáš Hrádecký");
        initialiseSquads(team, 11, "Harry Kane", "Leroy Sané", "Jamal Musiala", "Jamal Musiala", "Joshua Kimmich",
                "Joshua Kimmich", "Alphonso Davies", "Noussair Mazraoui", "Dayot Upamecano", "Kim Min-jae",
                "Manuel Neuer");
        initialiseSquads(team, 12, "Robert Lewandowski", "Ferrán Torres", "João Félix", "İlkay Gündoğan", "Gavi",
                "João Cancelo", "Frenkie de Jong", "Jules Koundé", "Ronald Araújo", "Alejandro Balde",
                "Marc-André ter Stegen");
        initialiseSquads(team, 13, "Jude Bellingham", "Vinicius Júnior", "Rodrygo", "Luka Modrić", "Federico Valverde",
                "Aurélien Tchouamén", "Eduardo Camavinga", "Dani Carvajal", "David Alaba", "Éder Militão",
                "Thibaut Courtois");
        initialiseSquads(team, 14, "Álvaro Morata", "Antoine Griezmann", "Samuel Lino", "Marcos Llorente",
                "Nahuel Molina", "Saúl Ñíguez", "Koke", "Rodrigo De Paul", "Mario Hermoso", "Stefan Savić",
                "Jan Oblak");
        initialiseSquads(team, 15, "Evanilson", "Mehdi Taremi", "Galeno", "Stephen Eustáquio", "Pepe", "Pepê",
                "Wendell", "João Mário Lopes", "Alan Varela", "David Carmo", "Diogo Costa");
        initialiseSquads(team, 16, "Ángel Di María", "Rafa Silva", "David Neres", "Fredrik Aursnes", "Petar Musa",
                "João Neves", "Orkun Kökçü", "António Silva", "Alexander Bah", "Nicolás Otamendi", "Anatolii Trubin");
        initialiseSquads(team, 17, "Dušan Vlahović", "Federico Chiesa", "Adrien Rabiot", "Filip Kostić",
                "Manuel Locatelli", "Fabio Miretti", "Weston McKennie", "Danilo", "Federico Gatti", "Gleison Bremer",
                "Wojciech Szczęsny");
        initialiseSquads(team, 18, "Lautaro Martínez", "Marcus Thuram", "Hakan Çalhanoğlu", "Denzel Dumfries",
                "Federico Dimarco", "Henrikh Mkhitaryan", "Nicolò Barella", "Francesco Acerbi", "Benjamin Pavard",
                "Alessandro Bastoni", "Yann Sommer");
        initialiseSquads(team, 19, "Rafael Leão", "Olivier Giroud", "Christian Pulisic", "Theo Hernández",
                "Ruben Loftus-Cheek", "Tijjani Reijnders", "Davide Calabria", "Rade Krunić", "Fikayo Tomori",
                "Malick Thiaw", "Mike Maignan");
    }

    public static teams[] initialiseTeams(teams managingTeam) {
        teams[] team = new teams[20];

        for (int i = 0; i <= 19; i++) {
            team[i] = new teams();
        }

        String[] teamNames = { managingTeam.name, "Manchester United", "Manchester City", "Liverpool",
                "Tottenham Hotspur", "Chelsea", "Paris Saint-Germain", "Monaco", "Ajax", "Borussia Dortmund",
                "Bayer Leverkusen", "Bayern Munich", "Barcelona", "Real Madrid", "Atlético Madrid", "Porto", "Benfica",
                "Juventus", "Inter Milan", "A.C. Milan" };
        for (int i = 0; i <= 19; i++) {
            setTeamNames(team, teamNames, i);
        }

        setSquads(team);

        return team;
    }

    public static String assignAction(int attackLevel) {
        String[] action = new String[5];
        int randomNumber = generateAction(300);
        String assignedAction;

        action[0] = "Goal Scored";
        action[1] = "Shot saved";
        action[2] = "Shot hit the post";
        action[3] = "Shot off target";
        action[4] = "No shot";

        if (attackLevel == 1) {
            if (randomNumber <= 1) {
                assignedAction = action[0];
            } else if (randomNumber <= 3) {
                assignedAction = action[1];
            } else if (randomNumber <= 5) {
                assignedAction = action[2];
            } else if (randomNumber <= 10) {
                assignedAction = action[3];
            } else {
                assignedAction = action[4];
            }
        } else if (attackLevel == 2) {
            if (randomNumber <= 3) {
                assignedAction = action[0];
            } else if (randomNumber <= 5) {
                assignedAction = action[1];
            } else if (randomNumber <= 7) {
                assignedAction = action[2];
            } else if (randomNumber <= 12) {
                assignedAction = action[3];
            } else {
                assignedAction = action[4];
            }
        } else if (attackLevel == 4) {
            if (randomNumber <= 7) {
                assignedAction = action[0];
            } else if (randomNumber <= 9) {
                assignedAction = action[1];
            } else if (randomNumber <= 11) {
                assignedAction = action[2];
            } else if (randomNumber <= 16) {
                assignedAction = action[3];
            } else {
                assignedAction = action[4];
            }
        } else if (attackLevel == 5) {
            if (randomNumber <= 9) {
                assignedAction = action[0];
            } else if (randomNumber <= 11) {
                assignedAction = action[1];
            } else if (randomNumber <= 13) {
                assignedAction = action[2];
            } else if (randomNumber <= 18) {
                assignedAction = action[3];
            } else {
                assignedAction = action[4];
            }
        } else {
            if (randomNumber <= 5) {
                assignedAction = action[0];
            } else if (randomNumber <= 7) {
                assignedAction = action[1];
            } else if (randomNumber <= 9) {
                assignedAction = action[2];
            } else if (randomNumber <= 14) {
                assignedAction = action[3];
            } else {
                assignedAction = action[4];
            }
        }

        return assignedAction;
    }

    public static int whichTeam(Random dice) {
        return dice.nextInt(2);
    }

    public static int generateAction(int probability) {
        Random dice = new Random();
        return dice.nextInt(probability);
    }

    public static String goalScorer(teams team) {
        int randomNumber = generateAction(100);
        String assignedAction = "";

        if (randomNumber <= 30) {
            assignedAction = team.player[0];
        } else if (randomNumber <= 47) {
            assignedAction = team.player[1];
        } else if (randomNumber <= 60) {
            assignedAction = team.player[2];
        } else if (randomNumber <= 68) {
            assignedAction = team.player[3];
        } else if (randomNumber <= 75) {
            assignedAction = team.player[4];
        } else if (randomNumber <= 82) {
            assignedAction = team.player[5];
        } else if (randomNumber <= 88) {
            assignedAction = team.player[6];
        } else if (randomNumber <= 92) {
            assignedAction = team.player[7];
        } else if (randomNumber <= 96) {
            assignedAction = team.player[8];
        } else if (randomNumber <= 99) {
            assignedAction = team.player[9];
        } else if (randomNumber == 100) {
            assignedAction = team.player[10];
        }

        return assignedAction;
    }

    public static void printAction(int minute, String assignedAction, String team) {
        System.out.println(minute + "': " + team + " - " + assignedAction);
    }

    public static void printScore(String homeTeam, int homeScore, int awayScore, String awayTeam) {
        System.out.println("Score: " + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);
    }

    private static int calculateMaxGoalLength(int score, int[] goalTime, String[] goalScorers) {
        int maxLength = 0;
        if (score == 0) {
            maxLength = 15;
        } else {
            for (int i = 0; i < score; i++) {
                if (goalScorers[i] != null) {
                    int length = String.valueOf(goalTime[i]).length() + goalScorers[i].length() + 3;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    public static void printFinalScore(String homeTeam, int homeScore, int awayScore, String awayTeam,
            int[] homeGoalTime, String[] homeGoalScorers, int[] awayGoalTime, String[] awayGoalScorers) {
        System.out.println();
        System.out.println();
        System.out.println("FINAL SCORE: ");
        System.out.println(homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);

        int maxHomeGoalLength = calculateMaxGoalLength(homeScore, homeGoalTime, homeGoalScorers);

        for (int i = 0; i < Math.max(homeScore, awayScore); i++) {
            if (i < homeScore && homeGoalScorers[i] != null) {
                System.out.print(
                        String.format("%-" + (maxHomeGoalLength) + "s", homeGoalTime[i] + "' " + homeGoalScorers[i])
                                + "| ");
            } else {
                String spaces = "";
                for (int j = 0; j < maxHomeGoalLength; j++) {
                    spaces += " ";
                }
                System.out.print(spaces + "| ");
            }

            if (i < awayScore && awayGoalScorers[i] != null) {
                System.out.print(awayGoalTime[i] + "' " + awayGoalScorers[i]);
            } else {
                System.out.print("           ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int inputNumber(String message, int lowerBound, int upperBound) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number >= lowerBound && number <= upperBound) {
                    isValidInput = true;
                } else {
                    System.out.println(
                            "Please enter a number between " + lowerBound + " and " + upperBound + " inclusive.");
                }

            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
            }
        }

        return number;
    }

    public static int changeTactic(int tactic) {

        String tacticName = "";

        if (tactic == 1) {
            tacticName = "Ultra defensive";
        } else if (tactic == 2) {
            tacticName = "Defensive";
        } else if (tactic == 3) {
            tacticName = "Balanced";
        } else if (tactic == 4) {
            tacticName = "Attacking";
        } else if (tactic == 5) {
            tacticName = "Ultra attacking";
        }

        System.out.println("You are currently using a " + tacticName + " tactic.");
        int changeTactic = inputNumber("Would you like to change? Type 0 for NO or 1 for YES", 0, 1);

        if (changeTactic == 0) {
            return tactic;
        } else {
            System.out.println("What would you like to change the tactic to? ");
            return inputNumber(
                    "Type 1 for Ultra defensive | 2 for Defensive | 3 for Balanced | 4 for Attacking | 5 for Ultra Attacking",
                    1, 5);
        }
    }

    public static void continueKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key to continue.");

        String c = scanner.nextLine();
    }

    public static void testAction(teams homeTeam, teams awayTeam) {
        int homeScore = 0;
        int awayScore = 0;

        int tactic = 3;

        teams[] randomTeam = new teams[2];
        randomTeam[0] = homeTeam;
        randomTeam[1] = awayTeam;

        String[] homeGoalScorers = new String[270];
        String[] awayGoalScorers = new String[270];
        int[] homeGoalTime = new int[270];
        int[] awayGoalTime = new int[270];
        int homeGoalScorersIndex = 0;
        int awayGoalScorersIndex = 0;

        teams assignedTeam;
        Random dice = new Random();

        for (int minute = 1; minute <= 90; minute++) {
            for (int actionWithinMinute = 1; actionWithinMinute <= 2; actionWithinMinute++) {
                String assignedAction = assignAction(tactic);

                if (assignedAction.equals("Goal Scored")) {
                    assignedTeam = randomTeam[whichTeam(dice)];

                    if (assignedTeam == randomTeam[0]) {
                        homeScore++;

                        String goalScorer = goalScorer(homeTeam);
                        homeGoalScorers[homeGoalScorersIndex] = goalScorer;
                        homeGoalTime[homeGoalScorersIndex] = minute;
                        homeGoalScorersIndex++;

                        printAction(minute, assignedAction, getName(assignedTeam));
                        System.out.println("GOAL - " + goalScorer);
                        printScore(getName(homeTeam), homeScore, awayScore, getName(awayTeam));

                        tactic = changeTactic(tactic);
                    } else if (assignedTeam == randomTeam[1]) {
                        awayScore++;

                        String goalScorer = goalScorer(awayTeam);
                        awayGoalScorers[awayGoalScorersIndex] = goalScorer;
                        awayGoalTime[awayGoalScorersIndex] = minute;
                        awayGoalScorersIndex++;

                        printAction(minute, assignedAction, getName(assignedTeam));
                        System.out.println("GOAL - " + goalScorer);
                        printScore(getName(homeTeam), homeScore, awayScore, getName(awayTeam));

                        tactic = changeTactic(tactic);
                    }
                }
                if (!assignedAction.equals("No shot") && !assignedAction.equals("Goal Scored")) {
                    assignedTeam = randomTeam[whichTeam(dice)];
                    printAction(minute, assignedAction, getName(assignedTeam));
                }
            }
        }
        printFinalScore(getName(homeTeam), homeScore, awayScore, getName(awayTeam), homeGoalTime, homeGoalScorers,
                awayGoalTime,
                awayGoalScorers);

        updateStats(homeTeam, awayTeam, homeScore, awayScore);
        continueKey();
    }

    public static void testBackgroundAction(teams homeTeam, teams awayTeam) {
        int homeScore = 0;
        int awayScore = 0;

        teams[] randomTeam = new teams[2];
        randomTeam[0] = homeTeam;
        randomTeam[1] = awayTeam;

        String[] homeGoalScorers = new String[270];
        String[] awayGoalScorers = new String[270];
        int[] homeGoalTime = new int[270];
        int[] awayGoalTime = new int[270];
        int homeGoalScorersIndex = 0;
        int awayGoalScorersIndex = 0;

        teams assignedTeam;
        Random dice = new Random();

        for (int minute = 1; minute <= 90; minute++) {
            for (int actionWithinMinute = 1; actionWithinMinute <= 2; actionWithinMinute++) {
                String assignedAction = assignAction(3);

                if (assignedAction.equals("Goal Scored")) {
                    assignedTeam = randomTeam[whichTeam(dice)];

                    if (assignedTeam == randomTeam[0]) {
                        homeScore++;

                        String goalScorer = goalScorer(homeTeam);
                        homeGoalScorers[homeGoalScorersIndex] = goalScorer;
                        homeGoalTime[homeGoalScorersIndex] = minute;
                        homeGoalScorersIndex++;
                    } else if (assignedTeam == randomTeam[1]) {
                        awayScore++;

                        String goalScorer = goalScorer(awayTeam);
                        awayGoalScorers[awayGoalScorersIndex] = goalScorer;
                        awayGoalTime[awayGoalScorersIndex] = minute;
                        awayGoalScorersIndex++;
                    }
                }
            }
        }
        printFinalScore(getName(homeTeam), homeScore, awayScore, getName(awayTeam), homeGoalTime, homeGoalScorers,
                awayGoalTime,
                awayGoalScorers);
        updateStats(homeTeam, awayTeam, homeScore, awayScore);
    }

    public static void updateTeamPositions(teams[] team) {

        teams[] sortedTeams = Arrays.copyOf(team, team.length);
        Arrays.sort(sortedTeams, Comparator.comparing(teams::getPosition));

        for (int i = 0; i < team.length; i++) {
            team[i].setPosition(sortedTeams[i].getPosition());
        }
    }

    public static void printTableHeader() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-25s | %-12s | %-6s | %-6s | %-9s | %-12s | %-12s | %-11s | %-6s |\n", "Pos.",
                "Team", "Games Played", "Wins", "Draws", "Losses", "Goals For", "Goals Against", "Goal Diff.",
                "Points");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void printTeamStats(teams team, int i) {
        System.out.printf("| %-6d | %-25s | %-12d | %-6d | %-6d | %-9d | %-12d | %-12d | %-11d | %-6d |\n",
                i, getName(team), getPlayed(team), getWins(team), getDraws(team), getLosses(team), getGoalsFor(team),
                getGoalsAgainst(team),
                (getGoalsFor(team) - getGoalsAgainst(team)), getPoints(team));
    }

    public static void printTableFooter() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void printTable(teams[] team) {
        teams[] sortedTeams = Arrays.copyOf(team, team.length);
        Arrays.sort(sortedTeams, Comparator.comparing(teams::getPoints)
                .thenComparing(teams::getGoalDifference)
                .thenComparing(teams::getGoalsFor).reversed());

        printTableHeader();

        for (int i = 0; i < sortedTeams.length; i++) {
            teams t = sortedTeams[i];
            printTeamStats(t, (i + 1));
        }

        printTableFooter();
    }

    public static void matchSimulation(int matchday, teams oppositionTeam, teams managingTeam) {
        System.out.println("Matchday " + matchday + ": You will be facing " + getName(oppositionTeam) + ".");
        testAction(managingTeam, oppositionTeam);
        System.out.println();
        System.out.println();
    }

    public static void matchAwaySimulation(int matchday, teams managingTeam, teams oppositionTeam) {
        System.out.println("Matchday " + matchday + ": You will be facing " + getName(oppositionTeam) + ".");
        testAction(oppositionTeam, managingTeam);
        System.out.println();
        System.out.println();
    }

    public static void otherGames(int i, int j, teams[] team) {
        testBackgroundAction(team[i], team[j]);
        updateTeamPositions(team);
    }

    public static void otherGames2(int i, int j, teams[] team) {
        testBackgroundAction(team[j], team[i]);
        updateTeamPositions(team);
    }

    public static void homeSeries(teams[] team, teams managingTeam) {
        // GW1
        matchSimulation(1, team[1], managingTeam);
        otherGames(2, 19, team);
        otherGames(3, 18, team);
        otherGames(4, 17, team);
        otherGames(5, 16, team);
        otherGames(6, 15, team);
        otherGames(7, 14, team);
        otherGames(8, 13, team);
        otherGames(9, 12, team);
        otherGames(10, 11, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW2
        matchSimulation(2, team[2], managingTeam);
        otherGames(1, 11, team);
        otherGames(3, 19, team);
        otherGames(4, 18, team);
        otherGames(5, 17, team);
        otherGames(6, 16, team);
        otherGames(7, 15, team);
        otherGames(8, 14, team);
        otherGames(9, 13, team);
        otherGames(10, 12, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW3
        matchSimulation(3, team[3], managingTeam);
        otherGames(1, 2, team);
        otherGames(4, 19, team);
        otherGames(5, 18, team);
        otherGames(6, 17, team);
        otherGames(7, 16, team);
        otherGames(8, 15, team);
        otherGames(9, 14, team);
        otherGames(10, 13, team);
        otherGames(11, 12, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW4
        matchSimulation(4, team[4], managingTeam);
        otherGames(1, 12, team);
        otherGames(2, 3, team);
        otherGames(5, 19, team);
        otherGames(6, 18, team);
        otherGames(7, 17, team);
        otherGames(8, 16, team);
        otherGames(9, 15, team);
        otherGames(10, 14, team);
        otherGames(11, 13, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW5
        matchSimulation(5, team[5], managingTeam);
        otherGames(1, 3, team);
        otherGames(2, 4, team);
        otherGames(6, 19, team);
        otherGames(7, 18, team);
        otherGames(8, 17, team);
        otherGames(9, 16, team);
        otherGames(10, 15, team);
        otherGames(11, 14, team);
        otherGames(12, 13, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW6
        matchSimulation(6, team[6], managingTeam);
        otherGames(1, 13, team);
        otherGames(2, 5, team);
        otherGames(3, 4, team);
        otherGames(7, 19, team);
        otherGames(8, 18, team);
        otherGames(9, 17, team);
        otherGames(10, 16, team);
        otherGames(11, 15, team);
        otherGames(12, 14, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW7
        matchSimulation(7, team[7], managingTeam);
        otherGames(1, 4, team);
        otherGames(2, 6, team);
        otherGames(3, 5, team);
        otherGames(8, 19, team);
        otherGames(9, 18, team);
        otherGames(10, 17, team);
        otherGames(11, 16, team);
        otherGames(12, 15, team);
        otherGames(13, 14, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW8
        matchSimulation(8, team[8], managingTeam);
        otherGames(1, 14, team);
        otherGames(2, 7, team);
        otherGames(3, 6, team);
        otherGames(4, 5, team);
        otherGames(9, 19, team);
        otherGames(10, 18, team);
        otherGames(11, 17, team);
        otherGames(12, 16, team);
        otherGames(13, 15, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW9
        matchSimulation(9, team[9], managingTeam);
        otherGames(1, 5, team);
        otherGames(2, 8, team);
        otherGames(3, 7, team);
        otherGames(4, 6, team);
        otherGames(10, 19, team);
        otherGames(11, 18, team);
        otherGames(12, 17, team);
        otherGames(13, 16, team);
        otherGames(14, 15, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW10
        matchSimulation(10, team[10], managingTeam);
        otherGames(1, 15, team);
        otherGames(2, 9, team);
        otherGames(3, 8, team);
        otherGames(4, 7, team);
        otherGames(5, 6, team);
        otherGames(11, 19, team);
        otherGames(12, 18, team);
        otherGames(13, 17, team);
        otherGames(14, 16, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW11
        matchSimulation(11, team[11], managingTeam);
        otherGames(1, 6, team);
        otherGames(2, 10, team);
        otherGames(3, 9, team);
        otherGames(4, 8, team);
        otherGames(5, 7, team);
        otherGames(12, 19, team);
        otherGames(13, 18, team);
        otherGames(14, 17, team);
        otherGames(15, 16, team);
        // GW12
        matchSimulation(12, team[12], managingTeam);
        otherGames(1, 16, team);
        otherGames(2, 11, team);
        otherGames(3, 10, team);
        otherGames(4, 9, team);
        otherGames(5, 8, team);
        otherGames(6, 7, team);
        otherGames(13, 19, team);
        otherGames(14, 18, team);
        otherGames(15, 17, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW13
        matchSimulation(13, team[13], managingTeam);
        otherGames(1, 7, team);
        otherGames(2, 12, team);
        otherGames(3, 11, team);
        otherGames(4, 10, team);
        otherGames(5, 9, team);
        otherGames(6, 8, team);
        otherGames(14, 19, team);
        otherGames(15, 18, team);
        otherGames(16, 17, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW14
        matchSimulation(14, team[14], managingTeam);
        otherGames(1, 17, team);
        otherGames(2, 13, team);
        otherGames(3, 12, team);
        otherGames(4, 11, team);
        otherGames(5, 10, team);
        otherGames(6, 9, team);
        otherGames(7, 8, team);
        otherGames(15, 19, team);
        otherGames(16, 18, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW15
        matchSimulation(15, team[15], managingTeam);
        otherGames(1, 8, team);
        otherGames(2, 14, team);
        otherGames(3, 13, team);
        otherGames(4, 12, team);
        otherGames(5, 11, team);
        otherGames(6, 10, team);
        otherGames(7, 9, team);
        otherGames(16, 19, team);
        otherGames(17, 18, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW16
        matchSimulation(16, team[16], managingTeam);
        otherGames(1, 18, team);
        otherGames(2, 15, team);
        otherGames(3, 14, team);
        otherGames(4, 13, team);
        otherGames(5, 12, team);
        otherGames(6, 11, team);
        otherGames(7, 10, team);
        otherGames(8, 9, team);
        otherGames(17, 19, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW17
        matchSimulation(17, team[17], managingTeam);
        otherGames(1, 9, team);
        otherGames(2, 16, team);
        otherGames(3, 15, team);
        otherGames(4, 14, team);
        otherGames(5, 13, team);
        otherGames(6, 12, team);
        otherGames(7, 11, team);
        otherGames(8, 10, team);
        otherGames(18, 19, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW18
        matchSimulation(18, team[18], managingTeam);
        otherGames(1, 19, team);
        otherGames(2, 17, team);
        otherGames(3, 16, team);
        otherGames(4, 15, team);
        otherGames(5, 14, team);
        otherGames(6, 13, team);
        otherGames(7, 12, team);
        otherGames(8, 11, team);
        otherGames(9, 10, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW19
        matchSimulation(19, team[19], managingTeam);
        otherGames(1, 10, team);
        otherGames(2, 18, team);
        otherGames(3, 17, team);
        otherGames(4, 16, team);
        otherGames(5, 15, team);
        otherGames(6, 14, team);
        otherGames(7, 13, team);
        otherGames(8, 12, team);
        otherGames(9, 11, team);
        System.out.println("End of gameweek!");
        continueKey();
    }

    public static void awayTour(teams[] team, teams managingTeam) {
        // GW20
        matchAwaySimulation(20, managingTeam, team[19]);
        otherGames2(1, 10, team);
        otherGames2(2, 18, team);
        otherGames2(3, 17, team);
        otherGames2(4, 16, team);
        otherGames2(5, 15, team);
        otherGames2(6, 14, team);
        otherGames2(7, 13, team);
        otherGames2(8, 12, team);
        otherGames2(9, 11, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW21
        matchAwaySimulation(21, managingTeam, team[18]);
        otherGames2(1, 19, team);
        otherGames2(2, 17, team);
        otherGames2(3, 16, team);
        otherGames2(4, 15, team);
        otherGames2(5, 14, team);
        otherGames2(6, 13, team);
        otherGames2(7, 12, team);
        otherGames2(8, 11, team);
        otherGames2(9, 10, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW22
        matchAwaySimulation(22, managingTeam, team[17]);
        otherGames2(1, 9, team);
        otherGames2(2, 16, team);
        otherGames2(3, 15, team);
        otherGames2(4, 14, team);
        otherGames2(5, 13, team);
        otherGames2(6, 12, team);
        otherGames2(7, 11, team);
        otherGames2(8, 10, team);
        otherGames2(18, 19, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW23
        matchAwaySimulation(23, managingTeam, team[16]);
        otherGames2(1, 18, team);
        otherGames2(2, 15, team);
        otherGames2(3, 14, team);
        otherGames2(4, 13, team);
        otherGames2(5, 12, team);
        otherGames2(6, 11, team);
        otherGames2(7, 10, team);
        otherGames2(8, 9, team);
        otherGames2(17, 19, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW24
        matchAwaySimulation(24, managingTeam, team[15]);
        otherGames2(1, 8, team);
        otherGames2(2, 14, team);
        otherGames2(3, 13, team);
        otherGames2(4, 12, team);
        otherGames2(5, 11, team);
        otherGames2(6, 10, team);
        otherGames2(7, 9, team);
        otherGames2(16, 19, team);
        otherGames2(17, 18, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW25
        matchAwaySimulation(25, managingTeam, team[14]);
        otherGames2(1, 17, team);
        otherGames2(2, 13, team);
        otherGames2(3, 12, team);
        otherGames2(4, 11, team);
        otherGames2(5, 10, team);
        otherGames2(6, 9, team);
        otherGames2(7, 8, team);
        otherGames2(15, 19, team);
        otherGames2(16, 18, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW26
        matchAwaySimulation(26, managingTeam, team[13]);
        otherGames2(1, 7, team);
        otherGames2(2, 12, team);
        otherGames2(3, 11, team);
        otherGames2(4, 10, team);
        otherGames2(5, 9, team);
        otherGames2(6, 8, team);
        otherGames2(14, 19, team);
        otherGames2(15, 18, team);
        otherGames2(16, 17, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW27
        matchAwaySimulation(27, managingTeam, team[12]);
        otherGames2(1, 16, team);
        otherGames2(2, 11, team);
        otherGames2(3, 10, team);
        otherGames2(4, 9, team);
        otherGames2(5, 8, team);
        otherGames2(6, 7, team);
        otherGames2(13, 19, team);
        otherGames2(14, 18, team);
        otherGames2(15, 17, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW28
        matchAwaySimulation(28, managingTeam, team[11]);
        otherGames2(1, 6, team);
        otherGames2(2, 10, team);
        otherGames2(3, 9, team);
        otherGames2(4, 8, team);
        otherGames2(5, 7, team);
        otherGames2(12, 19, team);
        otherGames2(13, 18, team);
        otherGames2(14, 17, team);
        otherGames2(15, 16, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW29
        matchAwaySimulation(29, managingTeam, team[10]);
        otherGames2(1, 15, team);
        otherGames2(2, 9, team);
        otherGames2(3, 8, team);
        otherGames2(4, 7, team);
        otherGames2(5, 6, team);
        otherGames2(11, 19, team);
        otherGames2(12, 18, team);
        otherGames2(13, 17, team);
        otherGames2(14, 16, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW30
        matchAwaySimulation(30, managingTeam, team[9]);
        otherGames2(1, 5, team);
        otherGames2(2, 8, team);
        otherGames2(3, 7, team);
        otherGames2(4, 6, team);
        otherGames2(10, 19, team);
        otherGames2(11, 18, team);
        otherGames2(12, 17, team);
        otherGames2(13, 16, team);
        otherGames2(14, 15, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW31
        matchAwaySimulation(31, managingTeam, team[8]);
        otherGames2(1, 14, team);
        otherGames2(2, 7, team);
        otherGames2(3, 6, team);
        otherGames2(4, 5, team);
        otherGames2(9, 19, team);
        otherGames2(10, 18, team);
        otherGames2(11, 17, team);
        otherGames2(12, 16, team);
        otherGames2(13, 15, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW32
        matchAwaySimulation(32, managingTeam, team[7]);
        otherGames2(1, 4, team);
        otherGames2(2, 6, team);
        otherGames2(3, 5, team);
        otherGames2(8, 19, team);
        otherGames2(9, 18, team);
        otherGames2(10, 17, team);
        otherGames2(11, 16, team);
        otherGames2(12, 15, team);
        otherGames2(13, 14, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW33
        matchAwaySimulation(33, managingTeam, team[6]);
        otherGames2(1, 13, team);
        otherGames2(2, 5, team);
        otherGames2(3, 4, team);
        otherGames2(7, 19, team);
        otherGames2(8, 18, team);
        otherGames2(9, 17, team);
        otherGames2(10, 16, team);
        otherGames2(11, 15, team);
        otherGames2(12, 14, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW34
        matchAwaySimulation(34, managingTeam, team[5]);
        otherGames2(1, 3, team);
        otherGames2(2, 4, team);
        otherGames2(6, 19, team);
        otherGames2(7, 18, team);
        otherGames2(8, 17, team);
        otherGames2(9, 16, team);
        otherGames2(10, 15, team);
        otherGames2(11, 14, team);
        otherGames2(12, 13, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW35
        matchAwaySimulation(35, managingTeam, team[4]);
        otherGames2(1, 12, team);
        otherGames2(2, 3, team);
        otherGames2(5, 19, team);
        otherGames2(6, 18, team);
        otherGames2(7, 17, team);
        otherGames2(8, 16, team);
        otherGames2(9, 15, team);
        otherGames2(10, 14, team);
        otherGames2(11, 13, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW36
        matchAwaySimulation(36, managingTeam, team[3]);
        otherGames2(1, 2, team);
        otherGames2(4, 19, team);
        otherGames2(5, 18, team);
        otherGames2(6, 17, team);
        otherGames2(7, 16, team);
        otherGames2(8, 15, team);
        otherGames2(9, 14, team);
        otherGames2(10, 13, team);
        otherGames2(11, 12, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW37
        matchAwaySimulation(37, managingTeam, team[2]);
        otherGames2(1, 11, team);
        otherGames2(3, 19, team);
        otherGames2(4, 18, team);
        otherGames2(5, 17, team);
        otherGames2(6, 16, team);
        otherGames2(7, 15, team);
        otherGames2(8, 14, team);
        otherGames2(9, 13, team);
        otherGames2(10, 12, team);
        System.out.println("End of gameweek!");
        continueKey();
        // GW38
        matchAwaySimulation(38, managingTeam, team[1]);
        otherGames2(2, 19, team);
        otherGames2(3, 18, team);
        otherGames2(4, 17, team);
        otherGames2(5, 16, team);
        otherGames2(6, 15, team);
        otherGames2(7, 14, team);
        otherGames2(8, 13, team);
        otherGames2(9, 12, team);
        otherGames2(10, 11, team);
        System.out.println("End of gameweek!");
        continueKey();
    }

    public static void main(String[] args) {
        teams managingTeam = whatTeam();
        teams[] team = initialiseTeams(managingTeam);

        homeSeries(team, team[0]);
        awayTour(team, team[0]);

        printTable(team);
    }
}
