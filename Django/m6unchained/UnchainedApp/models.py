from django.db import models


class Plataforma(models.Model):
    Nom = models.CharField(max_length=30, null=False, default="NullPlatformName")
    Data = models.DateTimeField(auto_now_add=True)


class Videojoc(models.Model):
    Nom = models.CharField(max_length=30, null=False, default="NullGameName")
    Preu = models.IntegerField(default=0)
    Nou = models.BooleanField(default=True)
    Plataforma = models.ForeignKey(Plataforma, on_delete=models.CASCADE)


class Usuari(models.Model):
    Nom = models.CharField(max_length=30, null=False, default="NoUserName")
    Plataforma = models.ManyToManyField(Plataforma, through='usuari_plataforma')
    Videojoc = models.ManyToManyField(Videojoc, through='usuari_videojoc')


class usuari_plataforma(models.Model):
    Usuari = models.ForeignKey(Usuari, on_delete=models.CASCADE, blank=True, null=True)
    Plataforma = models.ForeignKey(Plataforma, on_delete=models.CASCADE, blank=True, null=True)

    def __str__(self):
        return f'{self.Usuari} - {self.Plataforma}'


class usuari_videojoc(models.Model):
    Usuari = models.ForeignKey(Usuari, on_delete=models.CASCADE, blank=True, null=True)
    Videojoc = models.ForeignKey(Videojoc, on_delete=models.CASCADE, blank=True, null=True)

    def __str__(self):
        return f'{self.Usuari} - {self.Videojoc}'
