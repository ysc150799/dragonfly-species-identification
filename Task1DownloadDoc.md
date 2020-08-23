# Task 1 Downloader Script Guide

## Scrape Facebook Data of a post image url,id and description with just running the script

##### NOTE :- Before running the script make sure that you have logged in facebook developers and done the nescessary procedure for downloading.

1. While running the script change group variable below to the group id of the page from which you want to scrape and also change the token to the token you have generated. After that just put the location of the /folder/(jsonfile name) in location variable where you want to keep your intermediate json file

```
def main(x,y):
    group = '216593478390203'
    token = 'EAAJaZBipIeNYBAEuW1is0QNSXH7Bb9e9DJQ5z1tT0fIw8FLMmonqGC4Kim0tsDTj14P4SUZB7SbtPi8GQD3qofhHZAy1EUWCAys1ZBc5RAP91sTc79J1bSXnXZCrsZAsJBx1NDGicejW0G3B0spZA8CfmFeZAzsDJToC4XVWAmobI60at73hZB2J5WZAn1ZBFJrnCOYeiYKHFDAcHYuXZBZCwZAKkHsBK4BLC6wYSaoPpcm73xf4hA2ZAF8YP58sVvtNYBQ1QoZD'
    graph = facebook.GraphAPI(token)
    location_path = "data\demox1.json"
    x = datetime.strptime(x,'%d-%m-%Y')
    y = datetime.strptime(y,'%d-%m-%Y')
    field1 =  f'feed.until({y}).limit(400).since({x})'
    field2 ='{full_picture,attachments{description},updated_time}'
    fieldst = field1+field2
    fields = [str(fieldst)]
    profile = graph.get_object(group,fields = fields) 
    with open(location_path,"w") as outfile:
	        json.dump(profile,outfile,indent=4, separators=(',', ': '))
	        outfile.write('\n')
```

2. Set location_date path to the txt file in which date is present write there the start date from which you want to start extracting the data and set the months parameter below to a number which will iterate the process for that many months for example lets say you have written 1-1-2012 as a date in txt file after running the script you will get the data between 1-1-2012 and 1-(1+months)-2012 

```if __name__ == "__main__":
    location_date = 'data\date.txt'
    f = open(location_date, "r")
    date1 = f.read()
    date1f = datetime.strptime(date1,'%d-%m-%Y')
    date1f = date1f+relativedelta(months=+2)
    date1f = date1f.strftime('%d-%m-%Y')
    f.close()    
    main(date1,date1f)
    xtoc()
    f = open("data\date.txt", "w")
    f.write(date1f)
    f.close()
```
Now you are ready to run the script run it as many times as you want to iterate through the start and end date like if you want data from 2012 to 2013 and you have choosen months as 2 than write 1-1-2012 in date.txt and run the script 6 times 
