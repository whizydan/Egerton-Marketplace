import app from './app'
import { api_prefix, host, port } from './config'
import { createServer } from 'http'
import moment from 'moment'

const server = createServer(app)

server.listen(port, () => {
	const message = JSON.stringify({
		timestamp: moment().format('LLLL'),
		env: process.env.NODE_ENV,
		port,
		url: `http://${host}:${port}${api_prefix}/`
	})
	console.log(message)
})
