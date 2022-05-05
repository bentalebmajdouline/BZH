from django.http import HttpResponse
from django.shortcuts import render


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
    return render(request, "quizz/index.html", users)
