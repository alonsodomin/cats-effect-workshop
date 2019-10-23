import System.IO (hFlush, stdout)

main = do
  putStr "Tell me your name: "
  hFlush stdout
  name <- getLine
  putStrLn ("Hello, " ++ name ++ "!")