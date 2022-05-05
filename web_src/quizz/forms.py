from django import forms


class connectForm(forms.Form):
    username_input = forms.CharField(label="username", required=True, widget=forms.TextInput)
    password_input = forms.CharField(label="password", required=True, widget=forms.PasswordInput)
    username = forms.PasswordInput()
