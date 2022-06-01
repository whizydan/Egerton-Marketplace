import express, { Application } from 'express'
import helmet from 'helmet'
import v1 from '../api/v1'
import { api_prefix } from '../config'

export default ({ app }: { app: Application }) => {
	app.use(helmet())
	app.use(express.json({ limit: '100mb' }))
	app.use(express.urlencoded({ extended: true }))

	// Endpoints
	app.use(api_prefix, v1())
	return app
}
