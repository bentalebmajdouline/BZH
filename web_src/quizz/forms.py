from django import forms

class connectForm(forms.Form):
    username_input = forms.CharField(label="username")
    password_input = forms.CharField(label="password")
