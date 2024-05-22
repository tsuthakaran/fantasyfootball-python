class Player:
    def __init__(self, name):
        self.name = name
        self.goals = 0
        self.assists = 0

    def get_name(self):
        return self.name
    
    def get_goals(self):
        return self.goals
    
    def get_assists(self):
        return self.assists
