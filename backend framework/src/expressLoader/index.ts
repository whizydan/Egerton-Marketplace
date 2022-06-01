import { Application } from 'express'
import express from './express'

export default ({ app }: { app: Application }) => {
	/**
	 * Express process handle uncaught excptions, and unhandled rejections
	 */
	express({ app })
	return app
}
