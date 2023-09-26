from datetime import datetime

from mongoengine import Document, EmbeddedDocument, StringField, IntField, DateTimeField, ListField, EmbeddedDocumentField, URLField
from pymongo import MongoClient, collection
from mongoengine import *


class Imdb(EmbeddedDocument):
    id = IntField(required=True)
    rating = IntField()
    votes = IntField()

class Viewer(EmbeddedDocument):
    rating = IntField()
    numReviews = IntField()
    meter = IntField()

class Critics(EmbeddedDocument):
    rating = IntField()
    numReviews = IntField()
    meter = IntField()

class Tomatoes(EmbeddedDocument):
    viewer = EmbeddedDocumentField(Viewer)
    critic = EmbeddedDocumentField(Critics)
    dvd = DateTimeField()
    website = StringField()
    production = StringField()
    rotten = IntField()
    fresh = IntField()
    consensus = StringField()
    lastUpdated = DateTimeField()

class Awards(EmbeddedDocument):
    wins = IntField()
    nominations = IntField()
    text = StringField()

class movies(Document):
    plot = StringField()
    genres = ListField(StringField(choices=['Action', 'Animation', 'Comedy', 'Drama', 'Horror', 'Romantic', 'Thriller']),required=True)
    runtime = IntField()
    rated = StringField(min_length=0, max_length=100)
    cast = ListField(StringField())
    num_mflix_comments = IntField()
    poster = URLField()
    title = StringField(required=True)
    fullplot = StringField()
    countries = ListField(StringField())
    released = DateTimeField(default=datetime(1666, 1, 1), required=True)
    directors = ListField(StringField())
    writers = ListField(StringField())
    awards = EmbeddedDocumentField(Awards)
    lastupdated = DateTimeField()
    year = IntField()
    imdb = EmbeddedDocumentField(Imdb)
    type = StringField()
    tomatoes = EmbeddedDocumentField(Tomatoes)
    languages = ListField(StringField())


class coments(EmbeddedDocument):
    name = StringField()
    coment = StringField()
    date = DateTimeField(default=datetime(1666, 1, 1))
    rate = IntField(min_value=0,max_value=100)

class moviedamvi(Document):
    plot = StringField()
    genres = ListField(StringField(), required=True)
    cast = ListField(StringField())
    title = StringField(required=True)
    fullplot = StringField()
    released = DateTimeField(default=datetime(1666, 1, 1), required=True)
    directors = ListField(StringField())
    rated = IntField(min_value=0, max_value=100)
    sessions = ListField(StringField())
    comments = ListField(EmbeddedDocumentField(coments))

client=connect('movies', host='mongodb+srv://lyoko:lyoko@lyoko.1x8rqf3.mongodb.net/movies')

def insert():
    movie = movies()
    movie.plot = 'HOLA'
    movie.genres = ["Action", "Animation", "Comedy"]
    movie.runtime = 1
    movie.rated = "UNRATED"
    movie.cast = ["Charles Kayser", "Roberto Gonzalez", "Agustin Ramos"]
    movie.num_mflix_comments = 4
    movie.poster = "https://m.media-amazon.com/images/M/MV5BYzg2NjNhNTctMjUxMi00ZWU4LWI3Zj…"
    movie.title = "ZZZZ"
    movie.fullplot = "https://youtu.be/LEbsx5sYZ3s"
    movie.countries = ["Spain"]
    movie.released = datetime(1666, 1, 1)
    movie.directors = ["Roberto Gonzalez", "Agustin Ramos"]
    movie.writers = ["Roberto Gonzalez", "Agustin Ramos"]
    movie.year = 2000
    movie.type = "movie"
    movie.tomatoes = Tomatoes()
    movie.languages = ["Español de ESPAÑA", "English"]
    movie.save()
#insert()

def insertMovieDAMVI():
    mov=moviedamvi()
    mov.title='Blacksmith Scene'
    mov.plot='Three men hammer on an anvil and pass a bottle of beer around.'
    mov.fullplot="A stationary camera looks at a large anvil with a blacksmith behind it and one on either side. The smith in the middle draws a heated metal rod from the fire, places it on the anvil, and all three begin a rhythmic hammering. After several blows, the metal goes back in the fire. One smith pulls out a bottle of beer, and they each take a swig. Then, out comes the glowing metal and the hammering resumes."
    mov.directors=["William K.L. Dickson"]
    mov.rated=85
    mov.sessions=["15:00","18:00","22:00"]
    mov.released=datetime(2022, 12, 18)
    mov.genres=["Short"]
    coment1=coments(coment="I don’t like films",name="Stelio Kontos",date=datetime(2022, 12, 18),rate=85)
    coment2 = coments(coment="BUENA BRO", name="NOT TFUE", date=datetime(2022, 12, 18), rate=85)
    mov.comments=[coment1,coment2]
    mov.save()
#insertMovieDAMVI()


def add_comment(title):
    try:
        yourname = input('Your name? ')
        commentary = input(f'Your comment for {title}??')
        nota=int(input(f'Given rate to {title}?'))
        movie = moviedamvi.objects(title=title).first()
        if movie:
            comment=coments(name=yourname,coment=commentary,rate=nota,date=datetime.today())
            movie.update(push__comments=comment)
            movie.save()
            return f"Movie {title} now has {len(movie['comments'])} comments and has been Updated Succesfully"
        else:
            return f'Movie {title}  not Found'
    except Exception as ex:
        return f"Error: {ex}"
#print(add_comment('Blacksmith Scene'))

def update_rated():
    try:
        title=input('Title of the movie? ')
        movie = moviedamvi.objects(title=title).first()
        if movie:
            rates=[]
            for a in movie.comments:
                if 'rate' in a:
                    rates.append(a['rate'])
            if len(rates)>0:
                media = sum(rates) / len(rates)
                movie.update(rated=media)
                return f'Movie "{title}" Updated Succesfully, RATED = {media} '
            else:
                return 'Movie does not have comments'
        else:
            return 'Movie not Found'
    except DoesNotExist as ex:
        return f"Error: {ex}"

print(update_rated())
