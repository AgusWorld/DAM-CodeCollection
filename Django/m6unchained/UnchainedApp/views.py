import random

from django.http import HttpRequest, HttpResponse, JsonResponse, Http404
from django.shortcuts import render, get_object_or_404
from random import randint

# Create your views here.
from django.views.generic.base import View
from requests import Response

from .models import *
from .forms import *


# from .forms import *

class PlataformaRandom(View):
    # return HttpResponse(content='holi')
    def get(self, request):
        random_plataforma = random.choice(Plataforma.objects.all())
        return HttpResponse(content="Random Platform: " + random_plataforma.Nom)


class PlataformaRandomNew(View):
    # return HttpResponse(content='holi')
    def get(self, request):
        random_game_nou = random.choice(
            Videojoc.objects.select_related('Plataforma').filter(Plataforma__videojoc__Nou=True))
        random_platform_nou = Plataforma.objects.filter(id=random_game_nou.Plataforma.id)
        return HttpResponse(content="Random Platform with New Games: " + str(random_platform_nou[0].Nom))


def plataformasDe(request, username):
    user = get_object_or_404(Usuari, username=username)
    plataformas = Plataforma.objects.all()
    textoFinal = ""
    for platform in plataformas:
        textoFinal += platform.name + " - "
    return HttpResponse(content=textoFinal)


class AssociatePlatformToUser(View):
    def get(self, request, Plataforma_id, User_id):
        user = get_object_or_404(Usuari, id=User_id)
        plataforma = get_object_or_404(Plataforma, id=Plataforma_id)
        user.Plataforma.add(plataforma)

        return HttpResponse(content="it works, check the database")


class AssociateGameToUser(View):
    def get(self, request, Videojoc_id, User_id):
        user = get_object_or_404(Usuari, id=User_id)
        game = get_object_or_404(Videojoc, id=Videojoc_id)
        user.Videojoc.add(game)

        return HttpResponse(content="it works, check the database")


def create_platform(request):
    if request.method == "POST":
        form = createPlatformForm(request.POST)

        if form.is_valid():
            name = form.cleaned_data["name"]
            newPlatform = Plataforma(Nom=name)
            newPlatform.save()

    else:
        form = createPlatformForm()
    return render(request, "UnchainedApp/addPlataforma.html", {"form": form})


def create_videogame(request):
    if request.method == "POST":
        form = createVideogameForm(request.POST)

        Name = form.cleaned_data["Nom"]
        Preu = form.cleaned_data["Preu"]
        Nou = form.cleaned_data["Nou"]
        newGame = Videojoc(Nom=Name, Preu=Preu, Nou=Nou, Plataforma=None)
        newGame.save()
    else:
        form = createVideogameForm()
    return render(request, "UnchainedApp/addVideogame.html", {"form": form})


class platformsOf(View):
    def get(self, request, Usuari_id):
        users = usuari_plataforma.objects.filter(id=Usuari_id)
        stringFinal = "You should check the values in the admin site as well \n"
        if len(users) > 1:
            for u in users:
                stringFinal += u.Plataforma.__str__()
                stringFinal += " | "
        else:
            stringFinal += users[0].Plataforma.__str__()
        return HttpResponse(stringFinal)


class removeVideojoc(View):
    # return HttpResponse(content='holi')
    def get(self, request, Videojoc_id, Usuari_id):
        # Get the objects from the database
        game = get_object_or_404(Videojoc, pk=Videojoc_id)
        user = get_object_or_404(Usuari, pk=Usuari_id)

        # Remove the relation between the objects
        user.Videojoc.remove(game)

        # Redirect to a success page
        return HttpResponse(content="All good check database")
