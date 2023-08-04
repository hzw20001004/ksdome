dim objShell
set objShell=wscript.createObject("WScript.Shell")
iReturnCode=objShell.Run("java -jar gongye.jar",0,TRUE)

