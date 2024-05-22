import random
import math
from team import Team

class Match:
    def __init__ (self, home_team, away_team):
        self.home_team = home_team
        self.away_team = away_team
        self.home_team_goals = 0
        self.away_team_goals = 0
        self.home_team_goal_scorers = []
        self.away_team_goal_scorers = []
        self.home_team_assist_providers = []
        self.away_team_assist_providers = []
        self.home_team_goal_times = []
        self.away_team_goal_times = []

    def simulate_background_match(self):
        for minute in range(1, 91):
            for action_within_minute in range (1, 3):
                which_team_dice = random.randint(0, 1)
                assigned_team = [self.home_team, self.away_team][which_team_dice]
                assigned_action = self.assign_action(assigned_team.get_tactic())
                if assigned_action == "Goal Scored":
                    if assigned_team == self.home_team:
                        goal_scorer = self.select_goal_scorer(self.home_team)
                        assist_provider = self.select_assist_provider(self.home_team)
                        if goal_scorer == assist_provider:
                            assist_provider = None

                        self.home_team_goals += 1
                        self.home_team_goal_scorers.append(goal_scorer)
                        self.home_team_assist_providers.append(assist_provider)
                        self.home_team_goal_times.append(minute)
                        self.home_team.goals_for += 1
                        goal_scorer.goals += 1
                        self.away_team.goals_against += 1
                        if assist_provider != None:
                            assist_provider.assists += 1    
                    else:
                        goal_scorer = self.select_goal_scorer(self.away_team)
                        assist_provider = self.select_assist_provider(self.away_team)
                        if goal_scorer == assist_provider:
                            assist_provider = None

                        self.away_team_goals += 1
                        self.away_team_goal_scorers.append(goal_scorer)
                        self.away_team_assist_providers.append(assist_provider)
                        self.away_team_goal_times.append(minute)
                        self.away_team.goals_for += 1
                        goal_scorer.goals += 1
                        self.home_team.goals_against += 1
                        if assist_provider != None:
                            assist_provider.assists += 1    
        
        self.print_final_score()
        self.update_stats()


    def simulate_user_match(self, user_team):
        user_team.set_tactic(3)
        for minute in range(1, 91):
            for action_within_minute in range(1, 3):
                assigned_action = self.assign_action(user_team.get_tactic())

                if assigned_action == "Goal Scored":
                    assigned_team = [self.home_team, self.away_team][random.randint(0, 1)]
                    print(f"Minute {minute}: {assigned_action} - {assigned_team.get_name()}")

                    if assigned_team == self.home_team:
                        goal_scorer = self.select_goal_scorer(assigned_team)
                        assist_provider = self.select_assist_provider(assigned_team)
                        self.home_team_goals += 1
                        self.home_team_goal_scorers.append(goal_scorer)
                        if goal_scorer == assist_provider:
                            assist_provider = None

                        self.home_team_goals += 1
                        self.home_team_goal_scorers.append(goal_scorer)
                        self.home_team_assist_providers.append(assist_provider)
                        self.home_team_goal_times.append(minute)
                        self.home_team.goals_for += 1
                        self.away_team.goals_against += 1
                        goal_scorer.goals += 1
                        print(f"GOAL - {goal_scorer.get_name()}")
                        if assist_provider != None:
                            assist_provider.assists += 1    
                            print(f"ASSIST - {assist_provider.get_name()}")
                        else:
                            print("NO ASSIST")
                        print(f"Score: {self.home_team.get_name()} {self.home_team_goals} - {self.away_team_goals} {self.away_team.get_name()}")


                        self.change_tactic(user_team)

                    elif assigned_team == self.away_team:
                        goal_scorer = self.select_goal_scorer(assigned_team)
                        assist_provider = self.select_assist_provider(assigned_team)
                        self.away_team_goals += 1
                        self.away_team_goal_scorers.append(goal_scorer)
                        if goal_scorer == assist_provider:
                            assist_provider = None

                        self.away_team_goals += 1
                        self.away_team_goal_scorers.append(goal_scorer)
                        self.away_team_assist_providers.append(assist_provider)
                        self.away_team_goal_times.append(minute)
                        self.away_team.goals_for += 1
                        self.home_team.goals_against += 1
                        goal_scorer.goals += 1
                        print(f"GOAL - {goal_scorer.get_name()}")
                        if assist_provider != None:
                            assist_provider.assists += 1    
                            print(f"ASSIST - {assist_provider.get_name()}")
                        else:
                            print("NO ASSIST")
                        print(f"Score: {self.home_team.get_name()} {self.home_team_goals} - {self.away_team_goals} {self.away_team.get_name()}")


                        self.change_tactic(user_team)

                elif assigned_action != "No shot" and assigned_action != "Goal scored":
                    assigned_team = [self.home_team, self.away_team][random.randint(0, 1)]
                    print(f"Minute {minute}: {assigned_action} - {assigned_team.get_name()}")

        self.print_final_score()
        self.update_stats()
        self.continue_key()

    def assign_action(self, attack_level):

        actions = ["Goal Scored", "Shot saved", "Shot hit the post", "Shot off target", "No shot"]
        attack_levels = {
            1: [1, 3, 5, 10],
            2: [3, 5, 7, 12],
            3: [5, 7, 9, 14],
            4: [7, 9, 11, 16],
            5: [9, 11, 13, 18],
        }
        randomised_number = random.randint(1, 300)
        thresholds = attack_levels.get(attack_level, attack_levels[3])
        for index, threshold in enumerate(thresholds):
            if randomised_number <= threshold:
                return actions[index]
        else:
            return actions[4]
    
    def select_goal_scorer(self, team):
        goal_scorer_odds = [30, 47, 60, 68, 75, 82, 88, 92, 96, 99, 100]
        randomised_number = random.randint(1, 100)
        for index, odds in enumerate(goal_scorer_odds):
            if randomised_number <= odds:
                return team.players[index]
            
    def select_assist_provider(self, team):
        assist_provider_odds = [7, 20, 33, 58, 68, 81, 87, 91, 94, 98, 100]
        randomised_number = random.randint(1, 100)
        for index, odds in enumerate(assist_provider_odds):
            if randomised_number <= odds:
                return team.players[index]
            
    def print_final_score(self):
        home_team_name = self.home_team.get_name()
        away_team_name = self.away_team.get_name()
        home_goals = self.home_team_goals
        away_goals = self.away_team_goals
        team_name_width = max(len(home_team_name), len(away_team_name)) + 2
        goal_string_width = 40
        total_width = goal_string_width * 2 + 3

        print("\nFINAL SCORE")
        print("╔" + "═" * (total_width - 2) + "╗")
        header = f"║{home_team_name}{' ' * (goal_string_width - len(home_team_name) - 5)}║{f'{home_goals} - {away_goals}':^9}║{' ' * (goal_string_width - len(away_team_name) - 5)}{away_team_name}║"
        print(header)
        print("╠" + "═" * (total_width - 2) + "╣")

        home_goal_strings = []
        away_goal_strings = []
        max_goals = max(home_goals, away_goals)
        for i in range(max_goals):
            home_goal_string = ""
            home_assist_string = ""
            away_goal_string = ""
            away_assist_string = ""
            if i < home_goals and i < len(self.home_team_goal_scorers) and i < len(self.home_team_goal_times):
                home_goal_scorer = self.home_team_goal_scorers[i]
                home_goal_time = self.home_team_goal_times[i]
                home_goal_string = f"{home_goal_time}' {home_goal_scorer.get_name()}"
                if i < len(self.home_team_assist_providers):
                    home_assist_provider = self.home_team_assist_providers[i]
                    if home_assist_provider:
                        home_assist_string = f"Assist: {home_assist_provider.get_name()}"
            if i < away_goals and i < len(self.away_team_goal_scorers) and i < len(self.away_team_goal_times):
                away_goal_scorer = self.away_team_goal_scorers[i]
                away_goal_time = self.away_team_goal_times[i]
                away_goal_string = f"{away_goal_time}' {away_goal_scorer.get_name()}"
                if i < len(self.away_team_assist_providers):
                    away_assist_provider = self.away_team_assist_providers[i]
                    if away_assist_provider:
                        away_assist_string = f"Assist: {away_assist_provider.get_name()}"
            home_goal_strings.append(home_goal_string.ljust(goal_string_width, " "))
            home_goal_strings.append(home_assist_string.ljust(goal_string_width, " "))
            away_goal_strings.append(away_goal_string.rjust(goal_string_width, " "))
            away_goal_strings.append(away_assist_string.rjust(goal_string_width, " "))

        max_rows = max(len(home_goal_strings), len(away_goal_strings))
        for i in range(0, max_rows, 2):
            home_goal_string = home_goal_strings[i] if i < len(home_goal_strings) else " " * goal_string_width
            home_assist_string = home_goal_strings[i + 1] if i + 1 < len(home_goal_strings) else " " * goal_string_width
            away_goal_string = away_goal_strings[i] if i < len(away_goal_strings) else " " * goal_string_width
            away_assist_string = away_goal_strings[i + 1] if i + 1 < len(away_goal_strings) else " " * goal_string_width
            row = f"║{home_goal_string}│{away_goal_string}║"
            print(row.ljust(total_width, " "))
            if home_assist_string or away_assist_string:
                assist_row = f"║{home_assist_string}│{away_assist_string}║"
                print(assist_row.ljust(total_width, " "))

        print("╚" + "═" * (total_width - 2) + "╝")
        print()

    def change_tactic(self, user_team):
        tactic_list = {
            1: "Ultra defensive",
            2: "Defensive",
            3: "Balanced",
            4: "Attacking",
            5: "Ultra attacking"
        }
        print(f"You are currently using a {tactic_list[user_team.get_tactic()]} tactic.")
        change_tactic = input("Would you like to change tactic? Type 0 for NO or 1 for YES")
        if change_tactic == "1":
            user_team.set_tactic(input("Select new tactic: 1 for Ultra defensive, 2 for Defensive, 3 for Balanced, 4 for Attacking, 5 for Ultra attacking"))
            if user_team.tactic < 1 or user_team.tactic > 5:
                print("Invalid input. Please try again.")
                self.change_tactic(user_team)
            else:
                return
        elif change_tactic == "0":
            return
        else:
            print("Invalid input. Please try again.")
            self.change_tactic(user_team)

    def continue_key(self):
        input("Press any key to continue...")
        
    def update_stats(self):
        self.home_team.played += 1
        self.away_team.played += 1
        if self.home_team_goals > self.away_team_goals:
            self.home_team.won += 1
            self.away_team.lost += 1
        elif self.home_team_goals < self.away_team_goals:
            self.away_team.won += 1
            self.home_team.lost += 1
        else:
            self.home_team.drawn += 1
            self.away_team.drawn += 1

