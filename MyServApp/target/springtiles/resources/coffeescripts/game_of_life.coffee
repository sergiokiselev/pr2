
class GameOfLife
  currentCellGeneration: null
  currentGenerationNum: 0
  cellSize: 7
  numberOfRows: 128
  numberOfColumns: 128
  seedProbability: 0.3
  tickLength: 100
  canvas: null
  drawingContext: null
  stopCreteria: null
  liveCreteria: [2, 3]
  deadCreteria:[3]


  constructor: ->
    @createCanvas()
    @canvas.onmousedown = @defineImage
    @resizeCanvas()
    @createDrawingContext()
    @seed()

    @drawGrid()
    #@tick()

  createCanvas: ->
    temp = document.getElementById('canvasPlace')
    @canvas = document.createElement 'canvas'
    @canvas.clss = this
    temp.appendChild @canvas

  resizeCanvas: ->
    @canvas.height = @cellSize * @numberOfRows
    @canvas.width = @cellSize * @numberOfColumns

  createDrawingContext: ->
    @drawingContext = @canvas.getContext '2d'

  seed: ->
    @currentCellGeneration = []

    for row in [0...@numberOfRows]
      @currentCellGeneration[row] = []

      for column in [0...@numberOfColumns]
        seedCell = @createSeedCell row, column
        @currentCellGeneration[row][column] = seedCell

  createSeedCell: (row, column) ->
    isAlive: Math.random() < @seedProbability
    row: row
    column: column

  createCell: (row, column, isAlive) ->
    isAlive: isAlive
    row: row
    column: column

  drawGrid: ->
    for row in [0...@numberOfRows]
      for column in [0...@numberOfColumns]
        @drawCell @currentCellGeneration[row][column]

  drawCell: (cell) ->
    x = cell.column * @cellSize
    y = cell.row * @cellSize

    if cell.isAlive
      fillStyle = 'rgb(242, 198, 65)'
    else
      fillStyle = 'rgb(38, 38, 38)'

    @drawingContext.strokeStyle = 'rgba(242, 198, 65, 0.1)'
    @drawingContext.strokeRect x, y, @cellSize, @cellSize

    @drawingContext.fillStyle = fillStyle
    @drawingContext.fillRect x, y, @cellSize, @cellSize

  tick: =>
    @drawGrid()
    @evolveCellGeneration()
    @stopCreteria = setTimeout @tick, @tickLength

    #setTimeout @tick, @tickLength

  stop: ->
    clearTimeout @stopCreteria


  drawImageText: (text) ->
    context = @canvas.getContext("2d")
    context.fillRect(text.coords.x, text.coords.y, @cellSize, @cellSize)

  clearField: ->
    for i in @currentCellGeneration
      for item in i
        item.isAlive = false
    @drawGrid()
    @currentGenerationNum = 0



  defineImage: (evt) ->

    rect = this.getBoundingClientRect()
    clss = this.clss

    currentPos = {
      x: evt.clientX - rect.left,
      y: evt.clientY - rect.top
    }
    #currentPos = @getCurrentPos(evt)

    json = {
        "coords": {
            "x": currentPos.x,
            "y": currentPos.y
        }
    }

    i = Math.floor(currentPos.x / clss.cellSize)
    j = Math.floor(currentPos.y / clss.cellSize)
    cell = clss.createCell(j,i,!clss.currentCellGeneration[j][i].isAlive)
    clss.currentCellGeneration[j][i] = cell

    clss.drawCell(cell)



  evolveCellGeneration: ->
    newCellGeneration = []

    for row in [0...@numberOfRows]
      newCellGeneration[row] = []

      for column in [0...@numberOfColumns]
        evolvedCell = @evolveCell @currentCellGeneration[row][column]
        newCellGeneration[row][column] = evolvedCell

    @currentGenerationNum++
    document.getElementById('genNum').innerText = @currentGenerationNum
    @currentCellGeneration = newCellGeneration

  evolveCell: (cell) ->
    evolvedCell =
      row: cell.row
      column: cell.column
      isAlive: false

    numberOfAliveNeighbors = @countAliveNeighbors cell

    if cell.isAlive
      for i in @liveCreteria
        if i == numberOfAliveNeighbors
          evolvedCell.isAlive = true
          break
    else
      for i in @deadCreteria
        if i == numberOfAliveNeighbors
          evolvedCell.isAlive = true
          break

    evolvedCell

  addTrue: (value) ->
    value = true

  addFalse: (value) ->
    value = false

  countAliveNeighbors: (cell) ->
    lowerRowBound = Math.max cell.row - 1, 0
    upperRowBound = Math.min cell.row + 1, @numberOfRows - 1
    lowerColumnBound = Math.max cell.column - 1, 0
    upperColumnBound = Math.min cell.column + 1, @numberOfColumns - 1
    numberOfAliveNeighbors = 0

    for row in [lowerRowBound..upperRowBound]
      for column in [lowerColumnBound..upperColumnBound]
        continue if row is cell.row and column is cell.column

        if @currentCellGeneration[row][column].isAlive
          numberOfAliveNeighbors++

    numberOfAliveNeighbors

  getCurrentPos: (evt) ->
    rect = @canvas.getBoundingClientRect()

    result = JSON.stringify({
      x: evt.clientX - rect.left,
      y: evt.clientY - rect.top
    })

    result

window.GameOfLife = GameOfLife