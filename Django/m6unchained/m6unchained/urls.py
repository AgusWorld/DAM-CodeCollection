"""m6unchained URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from UnchainedApp.views import *

urlpatterns = [
    path('plataforma/<int:Plataforma_id>/<int:User_id>/', AssociatePlatformToUser.as_view()),
    path('videojoc/<int:Videojoc_id>/<int:User_id>/', AssociateGameToUser.as_view()),
    path('addPlataforma/', create_platform, name="addPlataformes"),
    path('addVideojocs/', create_videogame, name="addVideojocs"),
    path('plataformasDe/<int:Usuari_id>', platformsOf.as_view()),
    path('plataformaRandom/', PlataformaRandom.as_view()),
    path('plataformaRandomNou/', PlataformaRandomNew.as_view()),
    path('removeVideojoc/<int:Videojoc_id>/<int:Usuari_id>', removeVideojoc.as_view()),


    path('', admin.site.urls),
    path('admin/', admin.site.urls),
]
