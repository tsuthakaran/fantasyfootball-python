from team import Team
from player import Player

class League:
    def __init__(self):
        self.gameweek = 1
        self.teams = []
        self.user_team = self.create_user_team()
        self.teams.append(self.user_team)
        self.initialise_teams()

    def new_gameweek(self):
        self.gameweek += 1
    
    def get_gameweek(self):
        return self.gameweek
    
    def get_teams(self, number):
        return self.teams[number]

    def create_user_team(self):
        user_team_name = input("What team would you like to manage? ")
        print(f"Congratulations on managing {user_team_name}.")
        positions = ["Striker", "Right Winger", "Left Winger", "Attacking Midfielder", "Box to Box Midfielder",
                        "Attacking Full Back", "Defensive Midfielder", "Defensive Full Back", "Left Centre Back",
                        "Right Centre Back", "Goalkeeper"]
        players = [input(f"Who would you like to play at {position}? ") for position in positions]
        return Team(user_team_name, players)

    def initialise_teams(self):
        teams_data = {
            "Manchester United": ["Rasmus Højlund", "Marcus Rashford", "Bruno Fernandes", "Alejandro Garnacho", "Casemiro", "Luke Shaw", "Raphaël Varane", "Aaron Wan-Bissaka", "Kobbie Mainoo", "Lisandro Martínez", "André Onana"],
            "Manchester City": ["Erling Haaland", "Julián Álvarez", "Jeremy Doku", "Kevin De Bruyne", "Rodri", "Bernardo Silva", "Kyle Walker", "Rúben Dias", "Joško Gvardiol", "Nathan Aké", "Ederson"],
            "Liverpool": ["Mohamed Salah", "Diogo Jota", "Darwin Núñez", "Dominik Szoboszlai", "Curtis Jones", "Alexis Mac Allister", "Trent Alexander-Arnold", "Virgil van Dijk", "Andrew Robertson", "Ibrahima Konaté", "Alisson"],
            "Tottenham Hotspur": ["Son Heung-min", "Dejan Kulusevski", "James Maddison", "Brennan Johnson", "Pedro Porro", "Destiny Udogie", "Pape Matar Sarr", "Yves Bissouma", "Micky van de Ven", "Cristian Romero", "Guglielmo Vicario"],
            "Chelsea": ["Christopher Nkunku", "Raheem Sterling", "Cole Palmer", "Reece James", "Levi Colwill", "Conor Gallagher", "Enzo Fernández", "Moisés Caicedo", "Thiago Silva", "Levi Colwill", "Robert Sánchez"],
            "Paris Saint-Germain": ["Kylian Mbappé", "Gonçalo Ramos", "Ousmane Dembélé", "Warren Zaire-Emery", "Achraf Hakimi", "Vitinha", "Nuno Mendes", "Manuel Ugarte Ribeiro", "Marquinhos", "Milan Škriniar", "Gianluigi Donnarumma"],
            "Monaco": ["Wissam Ben Yedder", "Folarin Balogun", "Aleksandr Golovin", "Takumi Minamino", "Krépin Diatta", "Youssouf Fofana", "Denis Zakaria", "Ismail Jakobs", "Wilfried Singo", "Soungoutou Magassa", "Philipp Köhn"],
            "Ajax": ["Steven Bergwijn", "Brian Brobbey", "Chuba Akpom", "Steven Berghuis", "Branco van den Boomen", "Kristian Nökkvi Hlynsson", "Jorrel Hato", "Kenneth Taylor", "Devyne Rensch", "Josip Šutalo", "Jay Gorter"],
            "Borussia Dortmund": ["Julian Brandt", "Donyell Malen", "Marco Reus", "Karim Adeyemi", "Julian Ryerson", "Emre Can", "Marcel Sabitzer", "Mats Hummels", "Nico Schlotterbeck", "Niklas Süle", "Gregor Kobel"],
            "Bayer Leverkusen": ["Victor Boniface", "Álex Grimaldo", "Jonas Hofmann", "Florian Wirtz", "Jeremie Frimpong", "Exequiel Palacios", "Jonathan Tah", "Odilon Kossonou", "Granit Xhaka", "Edmond Tapsoba", "Lukáš Hrádecký"],
            "Bayern Munich": ["Harry Kane", "Leroy Sané", "Jamal Musiala", "Jamal Musiala", "Joshua Kimmich", "Joshua Kimmich", "Alphonso Davies", "Noussair Mazraoui", "Dayot Upamecano", "Kim Min-jae", "Manuel Neuer"],
            "Barcelona": ["Robert Lewandowski", "Ferrán Torres", "João Félix", "İlkay Gündoğan", "Gavi", "João Cancelo", "Frenkie de Jong", "Jules Koundé", "Ronald Araújo", "Alejandro Balde", "Marc-André ter Stegen"],
            "Real Madrid": ["Jude Bellingham", "Vinicius Júnior", "Rodrygo", "Luka Modrić", "Federico Valverde", "Aurélien Tchouamén", "Eduardo Camavinga", "Dani Carvajal", "David Alaba", "Éder Militão", "Thibaut Courtois"],
            "Atlético Madrid": ["Álvaro Morata", "Antoine Griezmann", "Samuel Lino", "Marcos Llorente", "Nahuel Molina", "Saúl Ñíguez", "Koke", "Rodrigo De Paul", "Mario Hermoso", "Stefan Savić", "Jan Oblak"],
            "Porto": ["Evanilson", "Mehdi Taremi", "Galeno", "Stephen Eustáquio", "Pepe", "Pepê", "Wendell", "João Mário Lopes", "Alan Varela", "David Carmo", "Diogo Costa"], 
            "Benfica": ["Ángel Di María", "Rafa Silva", "David Neres", "Fredrik Aursnes", "Petar Musa", "João Neves", "Orkun Kökçü", "António Silva", "Alexander Bah", "Nicolás Otamendi", "Anatolii Trubin"],
            "Juventus": ["Dušan Vlahović", "Federico Chiesa", "Adrien Rabiot", "Filip Kostić", "Manuel Locatelli", "Fabio Miretti", "Weston McKennie", "Danilo", "Federico Gatti", "Gleison Bremer", "Wojciech Szczęsny"],
            "Inter Milan": ["Lautaro Martínez", "Marcus Thuram", "Hakan Çalhanoğlu", "Denzel Dumfries", "Federico Dimarco", "Henrikh Mkhitaryan", "Nicolò Barella", "Francesco Acerbi", "Benjamin Pavard", "Alessandro Bastoni", "Yann Sommer"],
            "A.C. Milan": ["Rafael Leão", "Olivier Giroud", "Christian Pulisic", "Theo Hernández", "Ruben Loftus-Cheek", "Tijjani Reijnders", "Davide Calabria", "Rade Krunić", "Fikayo Tomori", "Malick Thiaw", "Mike Maignan"]
        }
        
        for team_name, players in teams_data.items():
            self.teams.append(Team(team_name, players))


