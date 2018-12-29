import sys
import requests as req

def GetQuotes(*args):
    ### sym link this file to ~/.config/libreoffice/4/user/Scripts/python

    #get the doc from the scripting context which is made available to all scripts
    desktop = XSCRIPTCONTEXT.getDesktop()
    model = desktop.getCurrentComponent()

    #check whether there's already an opened document. Otherwise, create a new one
    if not hasattr(model, "Sheets"):
        model = desktop.loadComponentFromURL(
            "private:factory/swriter","_blank", 0, () )
    
     #get the XText interface
    sheet = model.Sheets.Sheet1

    #create an XTextRange at the end of the document
    baseUrl = sheet.getCellRangeByName("T1").String
    apiKey = sheet.getCellRangeByName("T2").String

    for idx in range(1, 1000):
        ticker = sheet.getCellRangeByName("R" + str(idx)).String

        if ticker == "THEEND":
            break

        resp = req.get(baseUrl + ticker + apiKey)

        cellS = sheet.getCellRangeByName("S" + str(idx))
        cellS.String = resp.json()['Global Quote']['05. price']

    return None
