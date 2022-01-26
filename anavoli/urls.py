from django.urls import path
from . import views

urlpatterns=[
    path('',views.login),
    path('login.html',views.login),
    path('register.html',views.register),
    path('index.html',views.index),
    path('login',views.loginForm),
    path('register',views.registerForm),
    path('logout',views.logout),
    path('add',views.add),
]