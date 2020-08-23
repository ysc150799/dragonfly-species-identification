from datetime import datetime
from dateutil.relativedelta import *
import time
import json
import facebook
import pandas as pd
import csv
def main(x,y):
    group = '216593478390203'
    token = 'EAAJaZBipIeNYBANW2bq8RWFxBC9JVcG9Uxgdo6LiB4SZBu08O9N78S3kYlZCsJX88ZCbVwuKCKFQDgPgZBZA8sM56muBKrL4q5LZBZAEwHPnPa5Cd5DK4BwVQdJzZBs1E9cCt2ylrmwwFjg9U9CIzL6ZCAFeSDeMNvfqeYbaxZAM1CejtvywZBvACl5HbQTe1lSz0UUPj9TtZBW82hJ47xFZATi9448hvxwZBTDHGbbcCbAkF3TOSuPZAYt2SsUr'
    graph = facebook.GraphAPI(token)
    x = datetime.strptime(x,'%d-%m-%Y')
    y = datetime.strptime(y,'%d-%m-%Y')
    field1 =  f'id,name,feed.until({y}).limit(400).since({x})'
    field2 ='{full_picture,attachments{description}}'
    fieldst = field1+field2
    fields = [str(fieldst)]
    profile = graph.get_object(group,fields = fields) 
    with open("data\demox1.json","w") as outfile:
	        json.dump(profile,outfile,indent=4, separators=(',', ': '))
	        outfile.write('\n')

def xtoc():
    with open('data\demox1.json') as f:
       df = json.load(f)
       feed = df['feed']
       data = feed['data']
       for i in range(len(data)):
           if (len(data[i].keys()) != 3):
               continue
           picture = data[i]['full_picture']
           idx = data[i]['id']
           att = data[i]['attachments']
           d = att['data']
           if (len(d[0].keys()) != 1):
               continue
           des = d[0]['description']
           csvRow = [picture,idx,des]
           csvfile = "datax.csv"
           with open(csvfile, "a") as fp:
               wr = csv.writer(fp, dialect='excel')
               wr.writerow(csvRow)

if __name__ == "__main__":
    f = open("data\date.txt", "r")
    date1 = f.read()
    date1f = datetime.strptime(date1,'%d-%m-%Y')
    date1f = date1f+relativedelta(months=+2)
    date1f = date1f.strftime('%d-%m-%Y')
    f.close()    
    #main(date1,date1f)
    xtoc()
    f = open("data\date.txt", "w")
    f.write(date1f)
    f.close()
