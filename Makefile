BASE_DIR=$(shell pwd)
TARGET_FOLDER=$(BASE_DIR)/target

HASKELL_SRC=$(BASE_DIR)/src/main/haskell
HASKELL_TARGET=$(TARGET_FOLDER)/haskell

SCALA_TARGET=$(TARGET_FOLDER)/scala-2.13

all: haskell scala

$(HASKELL_TARGET)/HelloWorld: $(HASKELL_SRC)/HelloWorld.hs
	@mkdir -p $(@D)/HelloWorld.d
	ghc -o $(HASKELL_TARGET)/HelloWorld -hidir $(HASKELL_TARGET)/HelloWorld.d -odir $(HASKELL_TARGET)/HelloWorld.d $(HASKELL_SRC)/HelloWorld.hs

$(HASKELL_TARGET)/Greeter: $(HASKELL_SRC)/Greeter.hs
	@mkdir -p $(@D)/Greeter.d
	ghc -o $(HASKELL_TARGET)/Greeter -hidir $(HASKELL_TARGET)/Greeter.d -odir $(HASKELL_TARGET)/Greeter.d $(HASKELL_SRC)/Greeter.hs

$(SCALA_TARGET):
	sbt clean package

haskell: $(HASKELL_TARGET)/HelloWorld $(HASKELL_TARGET)/Greeter

scala: $(SCALA_TARGET)