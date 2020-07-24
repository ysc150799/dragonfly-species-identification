import json
import csv

def json_csv(location_path):
    with open(location_path) as f:
        data = json.load(f)
    posts = data['posts']
    users = data['users']
    u = {}
    for i in users.keys():
        u.update({i:users[i]['username']})
    csvHeader = ['ID','Species Name','Count','Date','Time','Location','Details','Habitat Ans','ObsCount','ObsType']
    csvfile = "data3.csv"
    with open(csvfile, "a",encoding='utf-8',newline='') as fp:
        wr = csv.writer(fp, dialect='excel')
        wr.writerow(csvHeader)
    #spName,count,details = [],[],[]
    #uid,date,location,obsCount,obsType,time,habAns = "","","","","","",""
    for i in posts.keys():
        for j in posts[i].keys():
            if(j == 'spName'):
                spName = (posts[i][j].split(','))[:-1]                    
            elif(j == 'count'):
                count = (posts[i][j].split(','))[:-1]
            elif(j == 'details'):
                details = (posts[i][j].split(','))[:-1]
            elif(j == 'uid'):
                uid = posts[i][j]
            elif(j == 'date'):
                date = posts[i][j]
            elif(j == 'location'):
                location = posts[i][j]
            elif(j == 'obsCount'):
                obsCount = posts[i][j]
            elif(j == 'obsType'):
                obsType = posts[i][j]
            elif(j == 'time'):
                time = posts[i][j]
            elif(j == 'habAns'):
                habAns = posts[i][j]
        for k in range(len(spName)):
            csvRow = [u[uid],spName[k],count[k],date,time,location,details[k],habAns,obsCount,obsType]
            with open(csvfile, "a",encoding='utf-8',newline='') as fp:
                   wr = csv.writer(fp, dialect='excel')
                   wr.writerow(csvRow)  
if __name__ == "__main__":
    location_path = 'data\dragonfly.json'
    json_csv(location_path)