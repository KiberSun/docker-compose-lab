import React, {useState} from 'react';
import './App.css';
import events from "node:events";

function App() {

    const [inputFieldText, inputFieldTextChange] = useState("");
    const [outputFieldText, outputFieldTextChange] = useState("");
    function inputFieldTextChangeHandler(e: any){
        inputFieldTextChange(e.target.value)
    }
    function outputFieldTextChangeHandler(e: any){
        outputFieldTextChange(e.target.value)
    }

    function sendData(){
        fetch("http://localhost:8080/api/text-storage", {
            method: 'POST',
            body: inputFieldText
        }).then(response => alert((response.status === 200) ? "Успешно!" : "Ошибка отправки!"))
            .catch(error => {alert("Ошибка отправки!")})
    }

    function receiveData(){
        fetch("http://localhost:8080/api/text-storage")
            .then(response => response.text())
            .then(text => {outputFieldTextChange(text);})
            .catch(error => {alert("Ошибка получения сообщения!")})
    }

  return (
    <div className="App">
      <div className="container">
          <textarea rows={13} value={inputFieldText} onChange={inputFieldTextChangeHandler}></textarea>
          <button onClick={sendData}>Отправить!</button>
      </div>
        <div className="container">
            <textarea rows={13} value={outputFieldText} onChange={outputFieldTextChangeHandler}></textarea>
            <button onClick={receiveData}>Получить!</button>
        </div>
    </div>
  );
}

export default App;
