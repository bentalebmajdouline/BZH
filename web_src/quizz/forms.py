from django import forms

class connectForm(forms.Form):
    username_input = forms.CharField(label="username", max_length="100", min_length="3" )
    password_input = forms.CharField(label="password", max_length="100",min_length="8")
