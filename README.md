# Shop_Angular-Spring
Demo application for selling and buying services online (Not finished). For this application the logged in users are stored in the cookies.

The program works on the localhost port 4200 - http://localhost:4200/main.

In order to run the program you need to run:
- front-end using *ng serve* in the therninal;
- back-end by running shop\src\main\java\com\zane\shop\ShopApplication.java;

### Automatically adding multiple users and services using Postman
Using Postman there's a possibillity to add premade users and services to better see the functionality.

![Demo](https://media3.giphy.com/media/2X2a0275a4GTcqd9D3/giphy.gif?cid=790b7611a3885003f876f22be52002e892e517f87dc2c4ff&rid=giphy.gif&ct=g)

### Main view 
Main view holds all info about the services available and the user is able to Log In or Sign Up if not yet registered. The services are categorised by the type and for each service the info that's being displayed is one of the service photos added, title of the service, username of the user that created this service and his or her photo. 

![Demo](https://media1.giphy.com/media/d4JznRdpImZEF2bUaw/giphy.gif?cid=790b7611b8bd5b62610e949350895fa0600844fe41df11e7&amp;rid=giphy.gif&amp;ct=g)

### Sign Up view
By pressing the Sign Up button the user is redirected to the view - http://localhost:4200/signUp. All fields are mandatory to fill when registering a new user. Fields username, email and phone number have to be unique. As the new user is registered successfully the app will direct the user to the view - http://localhost:4200/main. For registered users instead of Sign In and Sign Up buttons the button Add Service is displayed.

![Demo](https://media3.giphy.com/media/n8o4nyC7NTWWGCumIW/giphy.gif?cid=790b7611e3eb7a0c7a017c13d6ac4beb8580be6420fd20f8&rid=giphy.gif&ct=g)

### Profile view
As the user is logged in on the right upper corner the profile button is displayed. As the user clicks on the button he or she is redirected to - http://localhost:4200/profile. On this view users are able to edit their info and to add a service. On the right upper corner there's a Log out button which redirects users back to - http://localhost:4200/main. As the user is redirected the logged in user is deleted out of the cookies.

![Demo](https://media1.giphy.com/media/LiWN5pTZAOV2QUQZ9D/giphy.gif?cid=790b7611b73e08aa2e827a6a3e82cc56bc68131bc822ff6e&rid=giphy.gif&ct=g)

### Sign In view
When the user is validated as a registered user then the logged in user details are saved onto the cookies. 

![Demo](https://media1.giphy.com/media/8YgaTr1jGZez2Yg5Gu/giphy.gif?cid=790b7611f3074ec8349c46b89f380ee9b7253078ab70e36c&rid=giphy.gif&ct=g)

### Add Service view
When the user clicks on the Add Service button he or she is directed to the view - http://localhost:4200/addService. There's a possibility to add as many services as the user wants. And all services will be displayed on the view - http://localhost:4200/main. 

![Demo](https://media2.giphy.com/media/DSSHF3hacK02SulMgX/giphy.gif?cid=790b7611b132b462f0d974f94a8ba9db000aa6c24fccde60&rid=giphy.gif&ct=g)

### Service view
There's a possibility to view all services but the user can only delete his or her service. Each service has it's unique ID therefore each service can be accessed by url - http://localhost:4200/serviceView/{id}.

![Demo](https://media0.giphy.com/media/t4VtYWqxGAWjN4kw45/giphy.gif?cid=790b7611db72c04605bb0b1c7a458dbc3088160b71cfbcec&rid=giphy.gif&ct=g)

### Language options
In every view there's a possibility for the user to change language between english and latvian by pressing the button on the footers left side.

![Demo](https://media2.giphy.com/media/u0PIM87FtZ6vusQt9n/giphy.gif?cid=790b76116bdbe20011f4407d3eec94238358b10c3b7d54c0&rid=giphy.gif&ct=g)
