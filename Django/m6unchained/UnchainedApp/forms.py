from django import forms


class createPlatformForm(forms.Form):
    name = forms.CharField(required=True)


class createVideogameForm(forms.Form):
    Nom = forms.CharField(required=True)
    Preu = forms.IntegerField()
    Nou = forms.BooleanField(required=False)
