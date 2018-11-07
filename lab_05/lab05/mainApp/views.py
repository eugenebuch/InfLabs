from django.http import HttpResponse
from django.shortcuts import render
import json

with open("json_data.json", "r", encoding="utf8") as file:
	text = file.read()
data = json.loads(text)
administrative = len(data["struct"]["administrative"])
mega_facs = len(data["struct"]["science_edu"])
facs = 0
for mega_fac in data["struct"]["science_edu"]:
    facs += len(mega_fac["facs"])
programms = []
cafedras = []
groups = []
studentes = 0


for mega_fac in data["struct"]["science_edu"]:
    for fac in mega_fac["facs"]:
        cafedras.extend(fac["cafedras"])
        for cathedra in fac["cafedras"]:
            for education_program in cathedra["programms"]:
                programms.append(education_program)
                for year in education_program["year"]:
                    groups.extend(education_program["year"][year])
                    for k in education_program["year"][year]:
                        studentes += len(education_program["year"][year][0]["students"])
science_edu_count = facs + len(cafedras) + mega_facs



def index(request):
	return HttpResponse('<title>ПсевдоГлавная</title><a href="/hello" title="Основное меню">Hello, world!</a>')

def indexRender(request):
	return render(request, 'main/index.html', {})

def universityInfo(request):
	return render(request, 'main/universityInfo.html', {
			"json": data,
	        "facs": facs,
	        "cafedras": len(cafedras),
	        "mega_facs": mega_facs,
	        "administrative": administrative,
	        "science_edu_count": science_edu_count,
            "student": studentes
		})

def disciplineInfo(request):
    return render(request, 'main/disciplineInfo.html', {
        "progs_count": len(programms),
        "progs": programms
    })

def groupsInfo(request):
    return render(request, 'main/groupsInfo.html', {
        "groups": groups
    })


def departmentsInfo(request):
    return render(request, 'main/departmentsInfo.html', {
        "cafedras": cafedras
    })

def universityStructure(request):
    return render(request, 'main/universityStructure.html', {
        "data": data
    })