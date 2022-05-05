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
    f = ContactForm()
    f.base_fields['name'].label = "Username"
    another_f = CommentForm(auto_id=False)
    another_f.as_table().split('\n')[0]
    return render(request, "quizz/index.html", users)
