from player import Player

class Team:
    def __init__(self, name = "", players = [], tactic = 3, position = 0, played = 0, won = 0, drawn = 0, lost = 0, goals_for = 0, goals_against = 0):
        self.name = name
        self.players = [Player(player_name) for player_name in players] if players else []
        self.tactic = tactic
        self.played = played
        self.won = won
        self.drawn = drawn
        self.lost = lost
        self.goals_for = goals_for
        self.goals_against = goals_against

    def get_name(self):
        return self.name
    
    def get_tactic(self):
        return self.tactic
    
    def get_played(self):
        return self.played
    
    def get_won(self):
        return self.won
    
    def get_drawn(self):
        return self.drawn
    
    def get_lost(self):
        return self.lost
    
    def get_goals_against(self):
        return self.goals_against
    
    def get_goals_for(self):
        return self.goals_for
    
    def get_goal_difference(self):
        return self.goals_for - self.goals_against
    
    def get_points(self):
        return (self.won * 3) + self.drawn
    
    def set_teams(self, name, players):
        self.name = name
        for player_name in players:
            self.players.append(Player(player_name))

    def set_tactic(self, tactic):
        self.tactic = tactic
    
    def set_position(self, position):
        self.position = position

    def set_goal_difference(self, goal_difference):
        self.goal_difference = goal_difference
