from django.http import HttpResponse
from django.shortcuts import render

from .forms import connectForm



def index(request):
    users = [
        {
            "username": "admin1",
            "password": "admin1"
        },
        {
            "username": "admin2",
            "password": "admin2"
        },
        {
            "username": "user1",
            "password": "admin1"
        }
    ]
    if request.method == 'POST':
        form = connectForm(request.POST)
        if form.is_valid():
            return render(request, "quizz/connect_user.html", {'form': form})
    else:
        form = connectForm()
    return render(request, "quizz/index.html", {'form': form})
