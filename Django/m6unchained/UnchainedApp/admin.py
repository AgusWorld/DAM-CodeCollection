from django.contrib import admin
from django.contrib.admin import ModelAdmin
from .models import *


# Register your models here.
class PlataformesAdmin(ModelAdmin):
    pass


admin.site.register(Plataforma, ModelAdmin)


class UsuarisAdmin(ModelAdmin):
    pass


admin.site.register(Usuari, ModelAdmin)


class VideojocsAdmin(ModelAdmin):
    pass


admin.site.register(Videojoc, ModelAdmin)
