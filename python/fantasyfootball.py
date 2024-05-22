from league import League
from match import Match

class FantasyFootball:

    def __init__(self):
        self.league = League()

    def home_series(self):
        game_pairs_home = [
        [(2, 19), (3, 18), (4, 17), (5, 16), (6, 15), (7, 14), (8, 13), (9, 12), (10, 11)],  # GW1
        [(1, 11), (3, 19), (4, 18), (5, 17), (6, 16), (7, 15), (8, 14), (9, 13), (10, 12)],  # GW2
        [(1, 2), (4, 19), (5, 18), (6, 17), (7, 16), (8, 15), (9, 14), (10, 13), (11, 12)],  # GW3
        [(1, 12), (2, 3), (5, 19), (6, 18), (7, 17), (8, 16), (9, 15), (10, 14), (11, 13)],  # GW4
        [(1, 3), (2, 4), (6, 19), (7, 18), (8, 17), (9, 16), (10, 15), (11, 14), (12, 13)],  # GW5
        [(1, 13), (2, 5), (3, 4), (7, 19), (8, 18), (9, 17), (10, 16), (11, 15), (12, 14)],  # GW6
        [(1, 4), (2, 6), (3, 5), (8, 19), (9, 18), (10, 17), (11, 16), (12, 15), (13, 14)],  # GW7
        [(1, 14), (2, 7), (3, 6), (4, 5), (9, 19), (10, 18), (11, 17), (12, 16), (13, 15)],  # GW8
        [(1, 5), (2, 8), (3, 7), (4, 6), (10, 19), (11, 18), (12, 17), (13, 16), (14, 15)],  # GW9
        [(1, 15), (2, 9), (3, 8), (4, 7), (5, 6), (11, 19), (12, 18), (13, 17), (14, 16)],  # GW10
        [(1, 6), (2, 10), (3, 9), (4, 8), (5, 7), (12, 19), (13, 18), (14, 17), (15, 16)],  # GW11
        [(1, 16), (2, 11), (3, 10), (4, 9), (5, 8), (6, 7), (13, 19), (14, 18), (15, 17)],  # GW12
        [(1, 7), (2, 12), (3, 11), (4, 10), (5, 9), (6, 8), (14, 19), (15, 18), (16, 17)],  # GW13
        [(1, 17), (2, 13), (3, 12), (4, 11), (5, 10), (6, 9), (7, 8), (15, 19), (16, 18)],  # GW14
        [(1, 8), (2, 14), (3, 13), (4, 12), (5, 11), (6, 10), (7, 9), (16, 19), (17, 18)],  # GW15
        [(1, 18), (2, 15), (3, 14), (4, 13), (5, 12), (6, 11), (7, 10), (8, 9), (17, 19)],  # GW16
        [(1, 9), (2, 16), (3, 15), (4, 14), (5, 13), (6, 12), (7, 11), (8, 10), (18, 19)],  # GW17
        [(1, 19), (2, 17), (3, 16), (4, 15), (5, 14), (6, 13), (7, 12), (8, 11), (9, 10)],  # GW18
        [(1, 10), (2, 18), (3, 17), (4, 16), (5, 15), (6, 14), (7, 13), (8, 12), (9, 11)]   # GW19
        ]
        
        for index, pairs in enumerate(game_pairs_home):
            print(f"\n\n\nMatchday {self.league.get_gameweek()}: You will be facing {self.league.get_teams(self.league.get_gameweek()).get_name()}")
            match = Match(self.league.get_teams(0), self.league.get_teams(self.league.get_gameweek()))
            match.simulate_user_match(self.league.get_teams(0))

            for team1, team2 in pairs:
                match = Match(self.league.get_teams(team1), self.league.get_teams(team2))
                match.simulate_background_match()


            print("End of gameweek!\n")
            self.league.new_gameweek()
            match.continue_key()

    def away_series(self):
        game_pairs_away = [
            [(1, 10), (2, 18), (3, 17), (4, 16), (5, 15), (6, 14), (7, 13), (8, 12), (9, 11)],  # GW20
            [(1, 19), (2, 17), (3, 16), (4, 15), (5, 14), (6, 13), (7, 12), (8, 11), (9, 10)],  # GW21
            [(1, 9), (2, 16), (3, 15), (4, 14), (5, 13), (6, 12), (7, 11), (8, 10), (18, 19)],  # GW22
            [(1, 18), (2, 15), (3, 14), (4, 13), (5, 12), (6, 11), (7, 10), (8, 9), (17, 19)],  # GW23
            [(1, 8), (2, 14), (3, 13), (4, 12), (5, 11), (6, 10), (7, 9), (16, 19), (17, 18)],  # GW24
            [(1, 17), (2, 13), (3, 12), (4, 11), (5, 10), (6, 9), (7, 8), (15, 19), (16, 18)],  # GW25
            [(1, 7), (2, 12), (3, 11), (4, 10), (5, 9), (6, 8), (14, 19), (15, 18), (16, 17)],  # GW26
            [(1, 16), (2, 11), (3, 10), (4, 9), (5, 8), (6, 7), (13, 19), (14, 18), (15, 17)],  # GW27
            [(1, 6), (2, 10), (3, 9), (4, 8), (5, 7), (12, 19), (13, 18), (14, 17), (15, 16)],  # GW28
            [(1, 15), (2, 9), (3, 8), (4, 7), (5, 6), (11, 19), (12, 18), (13, 17), (14, 16)],  # GW29
            [(1, 5), (2, 8), (3, 7), (4, 6), (10, 19), (11, 18), (12, 17), (13, 16), (14, 15)],  # GW30
            [(1, 14), (2, 7), (3, 6), (4, 5), (9, 19), (10, 18), (11, 17), (12, 16), (13, 15)],  # GW31
            [(1, 4), (2, 6), (3, 5), (8, 19), (9, 18), (10, 17), (11, 16), (12, 15), (13, 14)],  # GW32
            [(1, 13), (2, 5), (3, 4), (7, 19), (8, 18), (9, 17), (10, 16), (11, 15), (12, 14)],  # GW33
            [(1, 3), (2, 4), (6, 19), (7, 18), (8, 17), (9, 16), (10, 15), (11, 14), (12, 13)],  # GW34
            [(1, 12), (2, 3), (5, 19), (6, 18), (7, 17), (8, 16), (9, 15), (10, 14), (11, 13)],  # GW35
            [(1, 2), (4, 19), (5, 18), (6, 17), (7, 16), (8, 15), (9, 14), (10, 13), (11, 12)],  # GW36
            [(1, 11), (3, 19), (4, 18), (5, 17), (6, 16), (7, 15), (8, 14), (9, 13), (10, 12)],  # GW37
            [(2, 19), (3, 18), (4, 17), (5, 16), (6, 15), (7, 14), (8, 13), (9, 12), (10, 11)]   # GW38
        ]
        for index, pairs in enumerate(game_pairs_away):    
            opponent_index = 39 - self.league.get_gameweek()
            print(f"Matchday {self.league.get_gameweek()}: You will be facing {self.league.get_teams(opponent_index).get_name()}")
            match = Match(self.league.get_teams(opponent_index), self.league.get_teams(0))
            match.simulate_user_match(self.league.get_teams(0))

            for team1, team2 in pairs:
                match = Match(self.league.get_teams(team1), self.league.get_teams(team2))
                match.simulate_background_match()

            print("End of gameweek!\n")
            self.league.new_gameweek()
            match.continue_key()

    def print_table(self):
        self.league_table = sorted(self.league.teams, key=lambda x: (-x.get_points(), -x.get_goal_difference(), -x.get_goals_for()), reverse=False)
        max_team_name_length = max(len(team.get_name()) for team in self.league_table) + 2 
        column_widths = [5, max_team_name_length, 5, 5, 5, 5, 5, 5, 6, 6] 
        total_width = sum(column_widths) + len(column_widths) + 1 

        print("\nLEAGUE TABLE")
        print("╔" + "═" * (total_width - 2) + "╗")
        header = "║{:^5}║{:^" + str(max_team_name_length) + "}║{:^5}║{:^5}║{:^5}║{:^5}║{:^5}║{:^5}║{:^6}║{:^6}║"
        print(header.format("Pos", "Team", "P", "W", "D", "L", "F", "A", "GD", "Pts"))
        print("╠" + "═" * (total_width - 2) + "╣")

        for index, team in enumerate(self.league_table):
            team_name = team.get_name()[:max_team_name_length - 2] 
            row = "║{:^5}║{:<" + str(max_team_name_length) + "}║{:^5}║{:^5}║{:^5}║{:^5}║{:^5}║{:^5}║{:^6}║{:^6}║"
            print(row.format(index + 1, team_name, team.get_played(), team.get_won(), team.get_drawn(), team.get_lost(), team.get_goals_for(), team.get_goals_against(), team.get_goal_difference(), team.get_points()))

        print("╚" + "═" * (total_width - 2) + "╝")
        print()

    def print_stats_tables(self):
        all_players = []
        for team in self.league.teams:
            all_players.extend(team.players)

        players_by_goals = sorted(all_players, key=lambda x: x.get_goals(), reverse=True)[:15]

        players_by_assists = sorted(all_players, key=lambda x: x.get_assists(), reverse=True)[:15]

        players_by_contributions = sorted(all_players, key=lambda x: x.get_goals() + x.get_assists(), reverse=True)[:15]

        max_name_length = max(len(player.get_name()) for player in all_players) + 2  
        column_widths = [5, max_name_length, 5]  
        total_width = sum(column_widths) + len(column_widths) + 1  
        print("\nTOP 15 SCORERS")
        print("╔" + "═" * (total_width - 2) + "╗")
        header = "║{:^5}║{:^" + str(max_name_length) + "}║{:^5}║"
        print(header.format("Pos", "Player", "Goals"))
        print("╠" + "═" * (total_width - 2) + "╣")

        for index, player in enumerate(players_by_goals):
            player_name = player.get_name()[:max_name_length - 2]  
            row = "║{:^5}║{:<" + str(max_name_length) + "}║{:^5}║"
            print(row.format(index + 1, player_name, player.get_goals()))

        print("╚" + "═" * (total_width - 2) + "╝")
        print()

        print("\nTOP 15 ASSIST PROVIDERS")
        print("╔" + "═" * (total_width) + "╗")
        header = "║{:^5}║{:^" + str(max_name_length) + "}║{:^7}║"
        print(header.format("Pos", "Player", "Assists"))
        print("╠" + "═" * (total_width) + "╣")

        for index, player in enumerate(players_by_assists):
            player_name = player.get_name()[:max_name_length - 2]  
            row = "║{:^5}║{:<" + str(max_name_length) + "}║{:^7}║"
            print(row.format(index + 1, player_name, player.get_assists()))

        print("╚" + "═" * (total_width) + "╝")
        print()

        print("\nTOP 15 GOAL CONTRIBUTORS")
        print("╔" + "═" * (total_width - 2) + "╗")
        header = "║{:^5}║{:^" + str(max_name_length) + "}║{:^5}║"
        print(header.format("Pos", "Player", "G+A"))
        print("╠" + "═" * (total_width - 2) + "╣")

        for index, player in enumerate(players_by_contributions):
            player_name = player.get_name()[:max_name_length - 2]  
            row = "║{:^5}║{:<" + str(max_name_length) + "}║{:^5}║"
            print(row.format(index + 1, player_name, player.get_goals() + player.get_assists()))

        print("╚" + "═" * (total_width - 2) + "╝")
        print()

if __name__ == "__main__":
    fantasy_football = FantasyFootball()
    fantasy_football.home_series()
    fantasy_football.away_series()
    fantasy_football.print_table()
    fantasy_football.print_stats_tables()

