
class Index
  checker: true
  settingsChecker: false
  form: null
  Life: null #new GameOfLife()
  setBut: document.getElementById('setBut')
  fsPlus: document.getElementById('fsPlus')
  fsMinus: document.getElementById('fsMinus')
  csPlus: document.getElementById('csPlus')
  csMinus: document.getElementById('csMinus')
  cstartStop: document.getElementById('startStop')
  saveBut: document.getElementById('saveBut')
  nextGener: document.getElementById('nextGen')
  genNum: document.getElementById('genNum')
  clearFieldBut: document.getElementById('clearField')
  saveToDbBut: document.getElementById('saveToDbBut')


  constructor: ->
    @Life = new GameOfLife()
    @fsPlus.onmousedown = @fsPlusOnclick
    @fsPlus.parent = this
    @fsMinus.onmousedown = @fsMinusOnclick
    @fsMinus.parent = this
    @setBut.onmousedown = @settings
    @setBut.parent = this
    @csPlus.onmousedown = @csPlusOnclick
    @csPlus.parent = this
    @csMinus.onmousedown = @csMinusOnclick
    @csMinus.parent = this
    @cstartStop.onmousedown = @startStop
    @cstartStop.parent = this
    @saveBut.onmousedown = @save
    @saveBut.parent = this
    @nextGener.onmousedown = @nextGen
    @nextGener.parent = this
    @clearFieldBut.onmousedown = @clearField
    @clearFieldBut.parent = this
    @saveToDbBut.onmousedown = @saveToDb
    @saveToDbBut.parent = this

#  saveToDb: ->
#    config = {
#      authorId: 1
#      configName: "lol",
#      description: "tralala",
#      tag: "super"
#    }
#
#    $.ajax "/settings/save",
#      type: "POST"
#      data: JSON.stringify(config)
#      error: (jqXHR, textStatus, errorThrown) ->
#        alert 'error'
#      success : (data, textStatus, jqXHR) ->
#        alert 'lol'
#

  fsPlusOnclick: ->
    @parent.Life.numberOfRows = @parent.Life.numberOfRows * 2
    @parent.Life.numberOfColumns = @parent.Life.numberOfColumns * 2
    @parent.Life.resizeCanvas()
    @parent.Life.drawGrid()
    @parent.Life.currentGenerationNum = 0


  fsMinusOnclick: ->
    @parent.Life.numberOfRows = @parent.Life.numberOfRows / 2
    @parent.Life.numberOfColumns = @parent.Life.numberOfColumns / 2
    @parent.Life.resizeCanvas()
    @parent.Life.drawGrid()
    @parent.Life.currentGenerationNum = 0


  csPlusOnclick: ->
    @parent.Life.cellSize = @parent.Life.cellSize + 1
    @parent.Life.resizeCanvas()
    @parent.Life.drawGrid()

  csMinusOnclick: ->
    @parent.Life.cellSize = @parent.Life.cellSize - 1
    @parent.Life.resizeCanvas()
    @parent.Life.drawGrid()

  nextGen: ->
    @parent.Life.evolveCellGeneration()
    @parent.Life.drawGrid()


  save: ->
    @parent.Life.deadCreteria = []
    @parent.Life.liveCreteria = []
    liveCrit = document.getElementById 'liveDiv'
    deadCrit = document.getElementById 'deadDiv'
    counter = 0
    for elem in liveCrit.children
      counter++
      if elem.checked
        @parent.Life.liveCreteria.push counter

    counter = 0
    for elem in deadCrit.children
      counter++
      if elem.checked
        @parent.Life.deadCreteria.push counter

    @parent.Life.currentGenerationNum = 0

  clearField: ->
    @parent.Life.clearField()

  settings: ->
    set = document.getElementById('settings')
    if @parent.settingsChecker == false
      set.style.visibility = 'visible'
      @parent.settingsChecker = true
    else
      set.style.visibility = 'hidden'
      @parent.settingsChecker = false


  startStop: ->
    if @parent.checker == false
      @parent.Life.stop()
      @parent.checker = true
    else
      @parent.Life.tick()
      @parent.checker = false

window.Index = Index