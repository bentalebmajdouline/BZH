from django.http import HttpResponse
from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login
from django.contrib import admin
from .models import models, Question, Theme, Choice
from django.urls import reverse

from .forms import connectForm


def index(request):
    questions = Question.objects.all()
    themes = Theme.objects.all()
    theme_selected = request.POST.get("theme")
    print(theme_selected)
    context = {"questions": questions, "themes": themes}
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']
        form = connectForm(request.POST)
        user = authenticate(request,
                            username=username,
                            password=password)
        if user is not None:
            if not user.get_user_permissions():
                return render(request, "quizz/connect_user.html", context)
            login(request, user)
            print(user.get_user_permissions())
            # return HttpResponse("<p>success</p>")
            # return render(request, "admin/")
            return redirect("../admin/")
        else:
            return render(request, "quizz/index.html", {'form': form})

    form = connectForm()
    return render(request, "quizz/index.html", {'form': form})


def question(request):
    questions = Question.objects.all()
    themes = Theme.objects.all()
    choices = Choice.objects.all()
    theme_selected = request.POST.get("theme")
    print(theme_selected)
    if theme_selected == Question.theme:
        print(theme_selected)
    context = {"questions": questions, "themes": themes, "choices": choices}
    return render(request, "quizz/question.html", context)
