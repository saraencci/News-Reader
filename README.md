## News-Reader
Android app to fetch latest News from newsapi.org

## TASKS TO BE EXECUTED
- HomeActivity.xml---Here we will show fragments so fragments will be inflated to HomeActivity based on sportsnews, technews, politics
and Headlines

- NewsActivity.xml----This activity will display details about news indepth when a news object is clicked on the recyclerview.
- NewsAdapter.java----The adapter for the news object that will bind the data from api to the recyclerview.
- NewsModel.java--The news model that will hold the news object after fetch from news api we will use room database to save news to memory.
- news_item_layout.xml---The news item layout that will be inflated to generate a single news view on the UI.
- AboutNewsApp.xml---This page will show all details about the news application e.g. libraries used, opensource tools and project info.
- Add more items to the left Navigation, also add icons to the items.
- NEWS FRAGMENTS WHICH WILL BE INFLATED TO HOMEACTIVITY TO BE DEVELOPED INCLUDE....SportnewsFragment...We can also develop one fragment and 
   pass different api Params since data is fetched from different api routes.....
- Develop Launcher icon for the Application.....  
- ApiInteface.java---to fetch data from restful Api....
- Animations we also need more than 5 animations in Applications someone should come up with places where we can apply
  animations especially on the SplashActivity.Java and in the transitions from on activity to activity and also in the recyclerview
  during scrolling down through the news....

## RESOURCES USED
   
   - Resources for Vector Drawables and icons---Flaticon.com
   - Project color scheme--https://material.io/resources/color/#!/?view.left=0&view.right=0&primary.color=00695C
   - News api doc-----https://newsapi.org/docs

## NEWS API BASE_URL
   - https://newsapi.org/v2/

