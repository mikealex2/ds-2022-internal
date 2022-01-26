from pathlib import Path
import os

BASE_DIR=Path(__file__).resolve().parent.parent
SECRET_KEY='django-insecure-lx0t(&cb9&9975vr2_b(@q=))k-g@u4u@=$j3na($7tv!s8y0-'
DEBUG=True
ALLOWED_HOSTS=[]
INSTALLED_APPS=[
    'anavoli.apps.AnavoliConfig',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
MIDDLEWARE=[
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
]
ROOT_URLCONF='ds.urls'
TEMPLATES=[{
        'BACKEND':'django.template.backends.django.DjangoTemplates',
        'DIRS':[os.path.join(BASE_DIR,'templates')],
        'APP_DIRS':True,
        'OPTIONS':{
            'context_processors':[
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]
WSGI_APPLICATION='ds.wsgi.application'
DATABASES={
    'default':{
        'ENGINE':'django.db.backends.sqlite3',
        'NAME':BASE_DIR/'db.sqlite3',
    }
}
AUTH_PASSWORD_VALIDATORS=[{
        'NAME': 'django.contrib.auth.password_validation.UserAttributeSimilarityValidator',
    },{
        'NAME': 'django.contrib.auth.password_validation.MinimumLengthValidator',
    },{
        'NAME': 'django.contrib.auth.password_validation.CommonPasswordValidator',
    },{
        'NAME': 'django.contrib.auth.password_validation.NumericPasswordValidator',
    },
]
LANGUAGE_CODE='en-us'
TIME_ZONE='UTC'
USE_I18N=True
USE_L10N=True
USE_TZ=True
STATIC_ROOT=''
STATIC_URL='/static/'
STATICFILES_DIRS=[os.path.join(BASE_DIR,'static')]
STATIC_ROOT=os.path.join(BASE_DIR,'assets')
DEFAULT_AUTO_FIELD='django.db.models.BigAutoField'