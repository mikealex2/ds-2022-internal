from django.shortcuts import render,redirect
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User,auth
import requests

def login(request):
    return render(request,'login.html')

def register(request):
    return render(request,'register.html')

@login_required
def index(request):
    return render(request,'index.html')

def loginForm(request):
    if(request.method=='POST'):
       username=request.POST['username']
       password=request.POST['password']
       user=auth.authenticate(username=username,password=password)
       if(user is not None):
           auth.login(request,user)
           return render(request,'index.html',{"user":user.username})
       else:
           return render(request,'login.html',{'message':"Wrong Password or Username!"})
    else:
        user=request.user
        if user.is_authenticated==True:
           return redirect('index.html')
        else:   
           return render(request,'login.html')
 
def registerForm(request):
    if(request.method=='POST'):
       username=request.POST['username']
       password=request.POST['password']
       password1=request.POST['password1']
       if(password1==password):
        if(User.objects.filter(username=username).exists()==False):
          user=User.objects.create_user(username=username,password=password1)
          user.save()
          return redirect('/')
        else:
            return render(request,'register.html',{'lol':'Username does exist'})
       else:
           return render(request,'register.html',{'lol':'Passwords are not the same'})
    else:
        return render(request,'login.html')

@login_required
def logout(request):
    auth.logout(request)
    return redirect('/')

@login_required
def add(request):
    if(request.method=='POST'):
        username=request.user.username
        citizenfirstname=request.POST['citizenFirstName']
        citizenlastname=request.POST['citizenLastName']
        email=request.POST['citizenEmail']
        citizenamka=int(request.POST['citizenAmka'])
        citizenstratnumber=int(request.POST['citizenStratNumber'])
        reason=request.POST['reasonOfDelay']
        print(reason)
        url='http://localhost:8080/project_war_exploded/api/applications'
        json={
            'username':username,
            'firstName':citizenfirstname,
            'lastName':citizenlastname,
            'email':email,
            'amka':citizenamka,
            'stratNumber':citizenstratnumber,
            'reasonDelay':reason,
        }
        requests.post(url,data=json)
        return redirect('/')