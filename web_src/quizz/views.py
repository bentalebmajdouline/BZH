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
            "password": "user1"
        }
    ]
    if request.method == 'POST':
        form = connectForm(request.POST)
        if form.is_valid():
            user_input = form.username_input
            user_password = form.password_input
            for user in users:
                if user["username"] == user_input and user["password"] == user_password:
                    return render(request, "quizz/connect_user.html", {'form': form, 'value_list': users})
            return HttpResponse("<p>WRONG INPUT</p>")
    else:
        form = connectForm()
    return render(request, "quizz/index.html", {'form': form, 'value_list': users})
