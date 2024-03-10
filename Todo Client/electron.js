import { app, BrowserWindow } from 'electron';
import { join } from 'path';
import isDev from 'electron-is-dev';

let mainWindow;

function createWindow() {
    mainWindow = new BrowserWindow({
        show: true,
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true,
        },
    });

    mainWindow.loadURL(`file://${join(__dirname, './index.html')}`);
    mainWindow.webContents.openDevTools();
    mainWindow.on('closed', () => (mainWindow = null));
}

app.on('ready', createWindow);
app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});

app.on('activate', () => {
    if (mainWindow === null) {
        createWindow();
    }
});